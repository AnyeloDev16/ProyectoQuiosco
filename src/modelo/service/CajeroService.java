package modelo.service;

import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.DatabaseConnector;
import modelo.dao.OperationResult;

public class CajeroService {
    
    private static CajeroService instance;
    private final DatabaseConnector conexion = DatabaseConnector.getConexion();

    private CajeroService() {
    };
    
    public static CajeroService getInstance() {
        if (instance == null) {
            instance = new CajeroService();
        }
        return instance;
    }
    
    public OperationResult agregarVenta(int idEmp, double totalVenta, int idMetPago, double totalCancelado){
        
        String sql = "{Call usp_InsertVenta(?,?,?,?,?,?,?)}";
        
        try(Connection conn = conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)){
            
            stmt.setInt(1, idEmp);
            stmt.setDouble(2, totalVenta);
            stmt.setInt(3, idMetPago);
            stmt.setDouble(4, totalCancelado);
            
            stmt.registerOutParameter(5, Types.INTEGER);
            stmt.registerOutParameter(6, Types.VARCHAR);
            stmt.registerOutParameter(7, Types.INTEGER);
            
            stmt.execute();
            
            int estadoInsert = stmt.getInt(5);
            String mensaje = stmt.getString(6);
            int idVenta = stmt.getInt(7);
            
            HashMap<String,Object> map = new HashMap<>();
            
            map.put("idVenta", idVenta);
            
            return new OperationResult(estadoInsert, mensaje, map);
            
        } catch (SQLException ex) {
        
            return new OperationResult(0, "Error de base de datos: " + ex.getMessage(), null);
        
        }
        
    }
    
    public OperationResult agregarDetalleVenta(int idVenta, int idProducto, int cant, double precioUnitario){
        
        String sql = "{Call usp_InsertDetalleVenta(?,?,?,?,?,?)}";
        
        try(Connection conn = conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)){
            
            stmt.setInt(1, idVenta);
            stmt.setInt(2, idProducto);
            stmt.setInt(3, cant);
            stmt.setDouble(4, precioUnitario);
            
            stmt.registerOutParameter(5, Types.INTEGER);
            stmt.registerOutParameter(6, Types.VARCHAR);
            
            stmt.execute();
            
            int estadoInsert = stmt.getInt(5);
            String mensaje = stmt.getString(6);
            
            return new OperationResult(estadoInsert, mensaje, null);
            
        } catch (SQLException ex) {
        
            return new OperationResult(0, "Error de base de datos: " + ex.getMessage(), null);
        
        }
        
    }
    
}
