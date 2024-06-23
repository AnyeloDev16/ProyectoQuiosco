package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.dao.OperationResult;
import modelo.dao.ProductDAO;
import modelo.entidad.Employee;
import modelo.entidad.Product;
import vista.AdministradorVista;
import vista.RegistrarProductoFrm;

public final class AdmProductoController implements MouseListener, ListSelectionListener, Redimensionable {

    AdministradorVista vistaAdm;
    Employee modelo;

    ProductDAO productoDAO;

    public AdmProductoController(AdministradorVista vistaAdm, Employee modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.productoDAO = new ProductDAO();
        cargarProductos();
        this.vistaAdm.jbtnRegistrarNuevoProducto.addMouseListener(this);
        this.vistaAdm.jbtnCambiarPrecioCompra.addMouseListener(this);
        this.vistaAdm.jbtnCambiarPrecioVenta.addMouseListener(this);
        this.vistaAdm.jbtnCambiarStock.addMouseListener(this);
        this.vistaAdm.jbtnCambiarImagen.addMouseListener(this);
        this.vistaAdm.jbtnEliminarProducto.addMouseListener(this);
        this.vistaAdm.jtblProductos.getSelectionModel().addListSelectionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vistaAdm.jbtnRegistrarNuevoProducto) {

            RegistrarProductoFrm vistaRegistrar = new RegistrarProductoFrm(vistaAdm, true);
            AdmRegProductoController regProdControler = new AdmRegProductoController(vistaRegistrar);
            regProdControler.iniciarRegistroEmpleado();
            cargarProductos();

        } else if (e.getSource() == vistaAdm.jbtnCambiarPrecioCompra) {

            String nuevoPrecioCompra = JOptionPane.showInputDialog(null, "Ingrese el nuevo Precio de Compra:", "Cambio de Precio", JOptionPane.PLAIN_MESSAGE);

            double nuevoPrecio = Double.parseDouble(nuevoPrecioCompra);

            int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());

            OperationResult or = productoDAO.cambiarPrecioCompra(idProducto, nuevoPrecio);

            vistaAdm.mostrarMensaje(or.getMessage());

            if (or.getOperationStatus() == 1) {
                vistaAdm.jlblPrecioCompra.setText(nuevoPrecioCompra);
            }

        } else if (e.getSource() == vistaAdm.jbtnCambiarPrecioVenta) {

            String nuevoPrecioVenta = JOptionPane.showInputDialog(null, "Ingrese el nuevo Precio de Venta:", "Cambio de Precio", JOptionPane.PLAIN_MESSAGE);

            double nuevoPrecio = Double.parseDouble(nuevoPrecioVenta);

            int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());

            OperationResult or = productoDAO.cambiarPrecioVenta(idProducto, nuevoPrecio);

            vistaAdm.mostrarMensaje(or.getMessage());

            if (or.getOperationStatus() == 1) {
                vistaAdm.jlblPrecioVenta.setText(nuevoPrecioVenta);
            }

        } else if (e.getSource() == vistaAdm.jbtnCambiarStock) {

            String nuevoStock = JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad:", "Cambio de cantidad", JOptionPane.PLAIN_MESSAGE);

            int nuevaCantidad = Integer.parseInt(nuevoStock);

            int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());

            OperationResult or = productoDAO.cambiarStock(idProducto, nuevaCantidad);

            vistaAdm.mostrarMensaje(or.getMessage());

            if (or.getOperationStatus() == 1) {
                vistaAdm.jlblCantidad.setText(nuevoStock);
                int i = vistaAdm.jtblProductos.getSelectedRow();
                vistaAdm.jtblProductos.setValueAt(nuevaCantidad, i, 2);
            }

        } else if (e.getSource() == vistaAdm.jbtnCambiarImagen) {

            int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                String rutaArchivo = archivo.getAbsolutePath();
                ImageIcon imagen = redimensionar(rutaArchivo, 108, 108);

                OperationResult or = productoDAO.cambiarFoto(idProducto, imagen);

                vistaAdm.mostrarMensaje(or.getMessage());

                if (or.getOperationStatus() == 1) {
                    vistaAdm.jlblProductoImg.setIcon(imagen);
                }

            }

        } else if (e.getSource() == vistaAdm.jbtnEliminarProducto) {

            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?",
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {

                int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());

                OperationResult or = productoDAO.eliminarProducto(idProducto);

                vistaAdm.mostrarMensaje(or.getMessage());

                if (or.getOperationStatus() == 1) {
                    vistaAdm.jlblNombreProductoI.setText("");
                    vistaAdm.jlblIDProductoI.setText("");
                    vistaAdm.jlblPrecioCompra.setText("");
                    vistaAdm.jlblPrecioVenta.setText("");
                    vistaAdm.jlblCantidad.setText("");
                    vistaAdm.jlblProductoImg.setIcon(null);

                    int filaSeleccionada = vistaAdm.jtblProductos.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        DefaultTableModel modeloT = (DefaultTableModel) vistaAdm.jtblProductos.getModel();
                        modeloT.removeRow(filaSeleccionada);
                    } else {
                        vistaAdm.mostrarMensaje("No se ha seleccionado ningún producto para eliminar.");
                    }
                }
            }
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (e.getValueIsAdjusting()) {

            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                int selectedRow = lsm.getMinSelectionIndex();

                if (selectedRow != -1) {

                    if (lsm == vistaAdm.jtblProductos.getSelectionModel()) {

                        int id_pro = (Integer) vistaAdm.jtblProductos.getValueAt(selectedRow, 0);

                        OperationResult or = productoDAO.obtenerProducto(id_pro);

                        Product pro = (Product) or.getData().get("Producto");

                        vistaAdm.jlblIDProductoI.setText(vistaAdm.jtblProductos.getValueAt(selectedRow, 0).toString());
                        vistaAdm.jlblNombreProductoI.setText(vistaAdm.jtblProductos.getValueAt(selectedRow, 1).toString());
                        vistaAdm.jlblPrecioCompra.setText(String.valueOf(pro.getPrecioCompra()));
                        vistaAdm.jlblPrecioVenta.setText(String.valueOf(pro.getPrecioVenta()));
                        vistaAdm.jlblCantidad.setText(String.valueOf(pro.getCantidad()));

                        vistaAdm.jlblProductoImg.setIcon(pro.getFoto());

                    }

                }
            }
        }

    }

    public void cargarProductos() {

        OperationResult or = productoDAO.obtenerListaProductos();

        ArrayList<Product> listaPro = (ArrayList<Product>) or.getData().get("ListaProducto");

        DefaultTableModel model = (DefaultTableModel) vistaAdm.jtblProductos.getModel();

        model.setRowCount(0);

        listaPro.stream()
                .forEach(p -> {

                    Object[] rowData = {
                        p.getIdProducto(),
                        p.getNombreProducto(),
                        p.getCantidad()
                    };
                    model.addRow(rowData);

                });

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

}
