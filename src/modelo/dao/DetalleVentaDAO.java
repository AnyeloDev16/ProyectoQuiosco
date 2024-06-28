package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.entidad.DetalleVenta;

public class DetalleVentaDAO {
    
    DatabaseConnector conexion = DatabaseConnector.getConexion();
    
    public OperationResult obtenerListaDetalleVenta(int idVenta){
        
        String sql = "SELECT [p].nombre_producto, [dv].cantidad, [dv].subtotal FROM DetalleVenta [dv] INNER JOIN Producto [p] ON [dv].producto_id = [p].producto_id WHERE [dv].venta_id = ?";
        
        ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<>();
        
        try(Connection conn = conexion.getConnection();
                PreparedStatement stmt = conn.prepareCall(sql)){
            
            stmt.setInt(1, idVenta);
            
            try(ResultSet rs = stmt.executeQuery()){
                
                while(rs.next()){
                    
                    DetalleVenta dv = DetalleVenta.builder()
                            .nombreProducto(rs.getString(1))
                            .cantidad(rs.getInt(2))
                            .subTotal(rs.getDouble(3))
                            .build();
                    
                    listaDetalleVenta.add(dv);
                    
                }

                if(!listaDetalleVenta.isEmpty()){
                    
                    HashMap<String, Object> map = new HashMap<>();
                    
                    map.put("ListaDetalleVenta", listaDetalleVenta);
                    
                    return new OperationResult(1, "Se obtuvo los detalles de la venta", map);
                    
                } else {
                    return new OperationResult(-1, "No se obtuvo los detalles de la venta", null);
                }
                
            }
            
        } catch (SQLException ex) {
            
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
            
        }
        
    }
    
}
