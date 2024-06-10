package Service;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import modelo.dao.Conexion;
import modelo.entidad.*;

public class ServiceLogin {
    
    private static ServiceLogin instance;
    private final Conexion conexion = Conexion.getConexion();

    private ServiceLogin() {
    };
    
    public static ServiceLogin getInstance() {
        if (instance == null) {
            instance = new ServiceLogin();
        }
        return instance;
    }
    
    public OperationResult accederSistema(Credencial crd){

        String sql = "{CALL usp_SelectEmpleado(?,?,?,?,?,?,?,?)}";
        
        try(Connection conn = conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)){
                    
            // Configurar parámetros de entrada
            stmt.setString(1, crd.getUsername());
            stmt.setString(2, crd.getPassword());

            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.registerOutParameter(6, Types.INTEGER);
            stmt.registerOutParameter(7, Types.INTEGER);
            stmt.registerOutParameter(8, Types.VARCHAR);
            
            stmt.execute();
            
            Empleado emp = new Empleado();
            emp.setNombre(stmt.getString(3));
            emp.setApellidoP(stmt.getString(4));
            emp.setApellidoM(stmt.getString(5));

            Rol rol = new Rol();
            rol.setIdRol(stmt.getInt(6));
            
            int estado = stmt.getInt(7);
            String mensaje = stmt.getString(8);
            
            HashMap<String, Object> map = new HashMap<>();
            
            map.put("Empleado", emp);
            map.put("Rol", rol);
            
            return new OperationResult(estado, mensaje, map);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }
            
    }
    
}
