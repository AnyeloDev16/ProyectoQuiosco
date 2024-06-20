package modelo.dao;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
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
