package controlador;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class CajeroRealizarVentaController implements Redimensionable {

    CajeroVista vista;
    Employee modelo;

    ProductDAO productDAO;

    public CajeroRealizarVentaController(CajeroVista vista, Employee modelo) {
        this.vista = vista;
        this.modelo = modelo;
        productDAO = new ProductDAO();
        cargarProductos();
    }

    private void cargarProductos() {
        OperationResult or = productDAO.obtenerListaProductosVenta();
        ArrayList<Product> listaProduct = (ArrayList<Product>) or.getData().get("ListaProducto");

        if (!listaProduct.isEmpty()) {
            
            TableModel modeloT = vista.jtblDetalleVenta.getModel();
            DefaultTableModel dtm = (DefaultTableModel)modeloT;
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
                    
                    int cant = 0;
                    
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        boolean hay = false;
                        
                        int idP = p.getIdProducto();
                        
                        for(int i = 0; i < dtm.getRowCount(); i++){
                            
                            int id = (Integer)dtm.getValueAt(i, 0);
                            
                            if(id == idP){
                                hay = true;
                                dtm.setValueAt(++cant, i, 2);
                                dtm.setValueAt(df.format(p.getPrecioVenta()*cant), i, 3);
                            }
                            
                        }
                        
                        if(!hay){
                            Object[] rowData = {
                            p.getIdProducto(),
                            p.getNombreProducto(),
                            ++cant,
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
