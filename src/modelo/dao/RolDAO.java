package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import modelo.service.OperationResult;

public class RolDAO {
    
    Conexion conexion = Conexion.getConexion();
    
    public OperationResult obtenerRol(int idemp){
        
        String sql = "SELECT rol_id FROM Empleado_Rol WHERE empleado_id = "+idemp+";";
        
        try(Connection conn = conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            if(rs.next()){
                
                int rol_id = rs.getInt(1);
                
                HashMap<String,Object> map = new HashMap<>();
                
                map.put("rol_id", rol_id);
                
                return new OperationResult(1, "Rol encontrado", map);
                
            } else {
                return new OperationResult(-1, "Rol no encontrado", null);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }
        
    }
    
}
