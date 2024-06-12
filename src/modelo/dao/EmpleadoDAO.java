package modelo.dao;

import java.sql.*;
import java.util.HashMap;
import modelo.entidad.Empleado;
import modelo.service.OperationResult;

public class EmpleadoDAO{

    Conexion conexion = Conexion.getConexion();

    public OperationResult obtenerEmpleado(int idEmpleado){
        
        String sql = "SELECT * FROM Empleado WHERE empleado_id = "+idEmpleado+";";
        
        try(Connection conn = conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            if(rs.next()){
                
                Empleado emp = new Empleado();
                
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellidoP(rs.getString(3));
                emp.setApellidoM(rs.getString(4));
                emp.setTelefono(rs.getString(5));
                emp.setDni(rs.getString(6));
                emp.setEstado(rs.getBoolean(7));
                
                HashMap<String, Object> map = new HashMap<>();
                
                map.put("Empleado", emp);
                
                return new OperationResult(1, "Empleado encontrado", map);
                               
            } else {
                return new OperationResult(-1, "Empleado no encontrado", null);
            }
            
        } catch (SQLException ex) {
            
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        
        }

    }
    
}
