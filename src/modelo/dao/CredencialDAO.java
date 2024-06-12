package modelo.dao;

import java.sql.*;
import java.util.HashMap;
import modelo.service.OperationResult;

public class CredencialDAO {
    
    Conexion conexion = Conexion.getConexion();

    public OperationResult obtenerContrasenia(String username){
        
        String sql = "SELECT empleado_id, password FROM Credencial WHERE username = '"+username+"';";
        
        try(Connection conn = conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            if(rs.next()){
                
                int emp_id = rs.getInt(1);
                String pass = rs.getString(2);
                
                HashMap<String,Object> map = new HashMap<>();
                
                map.put("empleado_id", emp_id);
                map.put("password", pass);
                
                return new OperationResult(1, "Username encontrado", map);
                
            } else {
                return new OperationResult(-1, "Username no encontrado", null);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }
        
    }
    
}
