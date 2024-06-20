package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import modelo.dao.OperationResult;
import modelo.dao.ProductDAO;
import modelo.entidad.Product;
import vista.RegistrarProductoFrm;

public class AdmRegProductoController implements MouseListener, Redimensionable{
    
    RegistrarProductoFrm vistaRegistrar;
    
    ProductDAO productDAO;

    public AdmRegProductoController(RegistrarProductoFrm vistaRegistrar) {
        this.vistaRegistrar = vistaRegistrar;
        this.productDAO = new ProductDAO();
        this.vistaRegistrar.jbtnRegistrarProducto.addMouseListener(this);
        this.vistaRegistrar.jbtnSeleccionarImagen.addMouseListener(this);
    }
    
    public void iniciarRegistroEmpleado() {
        
        this.vistaRegistrar.mostrarVentana();

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == this.vistaRegistrar.jbtnRegistrarProducto) {

            String nombreProducto = vistaRegistrar.jtxtNombreProducto.getText();
            double precioCompra = Double.parseDouble(vistaRegistrar.jtxtPrecioCompra.getText());
            double precioVenta = Double.parseDouble(vistaRegistrar.jtxtPrecioVenta.getText());
            
            ImageIcon foto = (ImageIcon)vistaRegistrar.jlblProductoImagen.getIcon();

            Product nuevoProducto = Product.builder()
                                        .nombreProducto(nombreProducto)
                                        .PrecioCompra(precioCompra)
                                        .PrecioVenta(precioVenta)
                                        .foto(foto)
                                        .build();
            
            OperationResult or = productDAO.guardarProducto(nuevoProducto);

            this.vistaRegistrar.mostrarMensaje(or.getMessage());

            if (or.getOperationStatus()== 1) {
                this.vistaRegistrar.cerrarVentana();
            }

        } else if (e.getSource() == this.vistaRegistrar.jbtnSeleccionarImagen){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                String rutaArchivo = archivo.getAbsolutePath();
                ImageIcon imagen = redimensionar(rutaArchivo, 108, 108);
                vistaRegistrar.jlblProductoImagen.setIcon(imagen);
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
