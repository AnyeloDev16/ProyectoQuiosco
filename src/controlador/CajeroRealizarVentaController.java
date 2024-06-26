package controlador;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.dao.OperationResult;
import modelo.dao.ProductDAO;
import modelo.entidad.Employee;
import modelo.entidad.Product;
import vista.CajeroVista;
import vista.ProductoComponent;

public class CajeroRealizarVentaController implements MouseListener, Redimensionable {

    CajeroVista vista;
    Employee modelo;

    ProductDAO productDAO;
    TableModel modeloT;
    DefaultTableModel dtm;
    DecimalFormat df = new DecimalFormat("#.00");

    public CajeroRealizarVentaController(CajeroVista vista, Employee modelo) {
        this.vista = vista;
        this.modelo = modelo;
        productDAO = new ProductDAO();
        cargarProductos();
        this.vista.jbtnEliminar.addMouseListener(this);
        this.vista.jbtnEliminarTodo.addMouseListener(this);
        modeloT = vista.jtblDetalleVenta.getModel();
        dtm = (DefaultTableModel) modeloT;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.jbtnEliminar) {

            int rowSelected = vista.jtblDetalleVenta.getSelectedRow();

            if (rowSelected != -1) {
                int cant = (Integer) dtm.getValueAt(rowSelected, 2);

                if (cant > 1) {

                    double precioTotal = Double.parseDouble((dtm.getValueAt(rowSelected, 3)).toString());

                    double precioUnitario = precioTotal / cant;

                    dtm.setValueAt(--cant, rowSelected, 2);
                    double precioResta = Double.parseDouble(df.format(precioTotal - precioUnitario));
                    dtm.setValueAt(precioResta, rowSelected, 3);
                    vista.jlblPrecioTotal.setText(df.format(Double.parseDouble(vista.jlblPrecioTotal.getText()) - precioUnitario));

                } else {
                    double precioTotal = Double.parseDouble((dtm.getValueAt(rowSelected, 3)).toString());
                    vista.jlblPrecioTotal.setText(df.format(Double.parseDouble(vista.jlblPrecioTotal.getText()) - precioTotal));
                    dtm.removeRow(rowSelected);
                }
            } else {
                vista.mostrarMensaje("Debes seleccionar un producto de la TABLA");
            }

        } else if (e.getSource() == vista.jbtnEliminarTodo) {

            int rowSelected = vista.jtblDetalleVenta.getSelectedRow();

            double precioTotal = Double.parseDouble((dtm.getValueAt(rowSelected, 3)).toString());
            vista.jlblPrecioTotal.setText(df.format(Double.parseDouble(vista.jlblPrecioTotal.getText()) - precioTotal));

            dtm.removeRow(rowSelected);

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void cargarProductos() {
        OperationResult or = productDAO.obtenerListaProductosVenta();
        ArrayList<Product> listaProduct = (ArrayList<Product>) or.getData().get("ListaProducto");

        if (!listaProduct.isEmpty()) {

            TableModel modeloT = vista.jtblDetalleVenta.getModel();
            DefaultTableModel dtm = (DefaultTableModel) modeloT;
            DecimalFormat df = new DecimalFormat("#.00");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.fill = GridBagConstraints.NONE;
            gbc.weightx = 0.0;
            gbc.weighty = 0.0;

            for (int index = 0; index < listaProduct.size(); index++) {
                Product p = listaProduct.get(index);

                ProductoComponent comProducto = new ProductoComponent();
                comProducto.jlblProductoImg.setIcon(redimensionar(p.getFoto(), 100, 100));
                comProducto.jlblNombreI.setText(p.getNombreProducto());
                comProducto.jlblPrecioI.setText(df.format(p.getPrecioVenta()));

                comProducto.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        boolean hay = false;

                        int idP = p.getIdProducto();

                        for (int i = 0; i < dtm.getRowCount(); i++) {

                            int id = (Integer) dtm.getValueAt(i, 0);

                            if (id == idP) {
                                hay = true;
                                int cant = (Integer) dtm.getValueAt(i, 2);
                                dtm.setValueAt(++cant, i, 2);
                                dtm.setValueAt(df.format(p.getPrecioVenta() * cant), i, 3);
                            }

                        }

                        if (!hay) {
                            Object[] rowData = {
                                p.getIdProducto(),
                                p.getNombreProducto(),
                                1,
                                p.getPrecioVenta()

                            };
                            dtm.addRow(rowData);
                        }

                        double precioTotalNuevo = Double.parseDouble(vista.jlblPrecioTotal.getText()) + p.getPrecioVenta();
                        vista.jlblPrecioTotal.setText(df.format(precioTotalNuevo));

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        comProducto.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        comProducto.setBackground(Color.WHITE);
                    }
                });

                gbc.gridx = index % 3;
                gbc.gridy = index / 3;

                switch (gbc.gridx) {
                    case 0:
                        gbc.insets = new java.awt.Insets(10, 10, 10, 5);
                        break;
                    case 1:
                        gbc.insets = new java.awt.Insets(10, 5, 10, 5);
                        break;
                    case 2:
                        gbc.insets = new java.awt.Insets(10, 5, 10, 10);
                        break;
                    default:
                        break;
                }

                this.vista.jpnlListaProductos.add(comProducto, gbc);
            }

            this.vista.jpnlListaProductos.revalidate();
            this.vista.jpnlListaProductos.repaint();

        }

    }

}
