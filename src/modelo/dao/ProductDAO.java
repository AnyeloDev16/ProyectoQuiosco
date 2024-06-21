package modelo.dao;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import modelo.entidad.Product;

public class ProductDAO {

    DatabaseConnector conexion = DatabaseConnector.getConexion();

    public OperationResult guardarProducto(Product producto) {

        String sql = "INSERT INTO Producto VALUES (?,?,?,0,?)";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, producto.getNombreProducto());
            stmt.setDouble(2, producto.getPrecioCompra());
            stmt.setDouble(3, producto.getPrecioVenta());
            
            BufferedImage bufferedImage = iconToBufferedImage(producto.getFoto());
            byte[] imageBytes = bufferedImageToBytes(bufferedImage);
            stmt.setBytes(4, imageBytes);

            int rowAffect = stmt.executeUpdate();

            if (rowAffect > 0) {
                return new OperationResult(1, "Producto registrado correctamente", null);
            } else {
                return new OperationResult(-1, "No se pudo registrar el producto", null);
            }

        } catch (Exception ex) {
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }

    }
    
    public OperationResult obtenerProducto(int idProducto){
        
        String sql = "SELECT precio_compra, precio_venta, stock, foto FROM Producto WHERE producto_id = ?;";
     
        try(Connection conn = conexion.getConnection();
                PreparedStatement stmt = conn.prepareCall(sql)){
            
            stmt.setInt(1, idProducto);
            
            try(ResultSet rs = stmt.executeQuery()){
                
                if(rs.next()){
                
                    Product producto = Product.builder()
                                        .PrecioCompra(rs.getDouble(1))
                                        .PrecioVenta(rs.getDouble(2))
                                        .cantidad(rs.getInt(3))
                                        .foto(new ImageIcon(rs.getBytes(4)))
                                        .build();
                
                    HashMap<String, Object> map = new HashMap<>();

                    map.put("Producto", producto);
                
                    return new OperationResult(1, "Se encontro el producto", map);
                    
                } else {
                    return new OperationResult(-1, "No se encontro ningun producto", null);
                }
                
            }
            
        } catch (SQLException ex) {
            
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
            
        }
        
    }
    
    public OperationResult obtenerListaProductos(){
        
        ArrayList<Product> listaProducto = new ArrayList<>();
        String sql = "SELECT producto_id, nombre_producto, stock FROM Producto";
     
        try(Connection conn = conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                
                Product producto = Product.builder()
                                        .idProducto(rs.getInt(1))
                                        .nombreProducto(rs.getString(2))
                                        .cantidad(rs.getInt(3))
                                        .build();
                
                listaProducto.add(producto);
                
            }
            
            HashMap<String, Object> map = new HashMap<>();

            map.put("ListaProducto", listaProducto);

            if (listaProducto.isEmpty()) {
                return new OperationResult(-1, "No se encontro ningun producto", map);
            } else {
                return new OperationResult(1, "Se encontro registro de empleados", map);
            }
            
        } catch (SQLException ex) {
            
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
            
        }
        
    }

    public OperationResult cambiarPrecioCompra(int idProduct, double nuevoPrecioCompra) {

        String sql = "UPDATE Producto SET precio_compra = ? WHERE id_producto = ?";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setDouble(1, nuevoPrecioCompra);
            stmt.setInt(2, idProduct);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return new OperationResult(1, "Precio COMPRA actualizada correctamente", null);
            } else {
                return new OperationResult(-1, "Producto no encontrado", null);
            }

        } catch (SQLException ex) {
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }

    }

    public OperationResult cambiarPrecioVenta(int idProduct, double nuevoPrecioVenta) {

        String sql = "UPDATE Producto SET precio_venta = ? WHERE id_producto = ?";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setDouble(1, nuevoPrecioVenta);
            stmt.setInt(2, idProduct);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return new OperationResult(1, "Precio VENTA actualizada correctamente", null);
            } else {
                return new OperationResult(-1, "Producto no encontrado", null);
            }

        } catch (SQLException ex) {
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }

    }

    public OperationResult cambiarStock(int idProduct, int nuevaCantidad) {

        String sql = "UPDATE Producto SET stock = ? WHERE id_producto = ?";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, nuevaCantidad);
            stmt.setInt(2, idProduct);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return new OperationResult(1, "Cantidad actualizada correctamente", null);
            } else {
                return new OperationResult(-1, "Producto no encontrado", null);
            }

        } catch (SQLException ex) {
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }

    }

    private byte[] bufferedImageToBytes(BufferedImage bufferedImage) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, "jpg", baos); // Cambia "jpg" por el formato de tu imagen si es necesario.
    return baos.toByteArray();
}

    private BufferedImage iconToBufferedImage(ImageIcon icon) {
        BufferedImage bufferedImage = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(icon.getImage(), 0, 0, null);
        g2d.dispose();
        return bufferedImage;
    }

}
