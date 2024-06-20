package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.dao.OperationResult;
import modelo.dao.ProductDAO;
import modelo.entidad.Employee;
import vista.AdministradorVista;
import vista.RegistrarProductoFrm;

public class AdmProductoController implements MouseListener{
    
    AdministradorVista vistaAdm;
    Employee modelo;
    
    ProductDAO productoDAO;

    public AdmProductoController(AdministradorVista vistaAdm, Employee modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.productoDAO = new ProductDAO();
        this.vistaAdm.jbtnRegistrarNuevoProducto.addMouseListener(this);
        this.vistaAdm.jbtnCambiarPrecioCompra.addMouseListener(this);
        this.vistaAdm.jbtnCambiarPrecioVenta.addMouseListener(this);
        this.vistaAdm.jbtnCambiarStock.addMouseListener(this);
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
