package modelo.dao;

import java.sql.*;
import java.util.HashMap;
import modelo.entidad.MetodoDePago;
import modelo.entidad.Pago;

public class PagoDAO {
    
    DatabaseConnector conexion = DatabaseConnector.getConexion();
    
    public OperationResult obtenerPago(int idVenta){
        
        String sql = "SELECT [mp].metodo_pago, [p].total_cancelado, [p].vuelto FROM Pago [p] INNER JOIN MetodoPago [mp] ON [p].metodo_pago_id = [mp].metodo_pago_id WHERE [p].venta_id = ?";

        Pago pago = null;
        
        try(Connection conn = conexion.getConnection();
                PreparedStatement stmt = conn.prepareCall(sql)){
            
            stmt.setInt(1, idVenta);
            
            try(ResultSet rs = stmt.executeQuery()){
                
                if(rs.next()){
                    
                    pago = Pago.builder()
                            .metodoDePago(new MetodoDePago(rs.getString(1)))
                            .totalCancelado(rs.getDouble(2))
                            .vuelto(rs.getDouble(3))
                            .build();             
                    
                }
                
            }                      
            
            if(pago != null){
                
                HashMap<String, Object> mapPago = new HashMap<>();
                
                mapPago.put("Pago", pago);
                
                return new OperationResult(1, "Pago encontrado", mapPago);
            } else {
                 return new OperationResult(-1, "Pago no encontrado", null);
            }
            
        } catch (SQLException ex) {            
            return new OperationResult(0, "Error: " + ex.getMessage(), null);           
        }
        
    }
    
}
