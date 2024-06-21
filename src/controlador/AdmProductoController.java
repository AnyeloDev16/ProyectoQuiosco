package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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

public final class AdmProductoController implements MouseListener, ListSelectionListener{
    
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
        this.vistaAdm.jtblProductos.getSelectionModel().addListSelectionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getSource() == vistaAdm.jbtnRegistrarNuevoProducto){
            
            RegistrarProductoFrm vistaRegistrar = new RegistrarProductoFrm(vistaAdm, true);
            AdmRegProductoController regProdControler = new AdmRegProductoController(vistaRegistrar);            
            regProdControler.iniciarRegistroEmpleado();
            
        } else if (e.getSource() == vistaAdm.jbtnCambiarPrecioCompra){
            
            String nuevoPrecioCompra = JOptionPane.showInputDialog(null, "Ingrese el nuevo Precio de Compra:", "Cambio de Precio", JOptionPane.PLAIN_MESSAGE);
            
            int nuevoPrecio = Integer.parseInt(nuevoPrecioCompra);
            
            int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());
            
            OperationResult or = productoDAO.cambiarPrecioCompra(idProducto, nuevoPrecio);
            
            vistaAdm.mostrarMensaje(or.getMessage());
            
            if(or.getOperationStatus() == 1){
                vistaAdm.jlblPrecioCompra.setText(nuevoPrecioCompra);
            }
            
        } else if (e.getSource() == vistaAdm.jbtnCambiarPrecioVenta){
            
            String nuevoPrecioVenta = JOptionPane.showInputDialog(null, "Ingrese el nuevo Precio de Venta:", "Cambio de Precio", JOptionPane.PLAIN_MESSAGE);
            
            int nuevoPrecio = Integer.parseInt(nuevoPrecioVenta);
            
            int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());
            
            OperationResult or = productoDAO.cambiarPrecioVenta(idProducto, nuevoPrecio);
            
            vistaAdm.mostrarMensaje(or.getMessage());
            
            if(or.getOperationStatus() == 1){
                vistaAdm.jlblPrecioVenta.setText(nuevoPrecioVenta);
            }
            
        } else if (e.getSource() == vistaAdm.jbtnCambiarStock){
            
            String nuevoStock = JOptionPane.showInputDialog(null, "Ingrese el nuevo Precio de Venta:", "Cambio de Precio", JOptionPane.PLAIN_MESSAGE);
            
            int nuevaCantidad = Integer.parseInt(nuevoStock);
            
            int idProducto = Integer.parseInt(vistaAdm.jlblIDProductoI.getText());
            
            OperationResult or = productoDAO.cambiarStock(idProducto, nuevaCantidad);
            
            vistaAdm.mostrarMensaje(or.getMessage());
            
            if(or.getOperationStatus() == 1){
                vistaAdm.jlblCantidad.setText(nuevoStock);
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

    public void cargarProductos(){
        
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
