package Service;

import modelo.dao.*;
import modelo.entidad.*;
import java.sql.*;

public class ServiceAdministrador {

    private static ServiceAdministrador instance;
    private final Conexion conexion = Conexion.getConexion();

    private ServiceAdministrador() {
    };
    
    public static ServiceAdministrador getInstance() {
        if (instance == null) {
            instance = new ServiceAdministrador();
        }
        return instance;
    }

    // Servicios
    public StoredProcedureResult agregarEmpleadoConRolYCredencias(Empleado emp, Credencial cred, int idrol) {
        String sql = "{CALL usp_InsertEmployeerWithRolAndCredenciales(?,?,?,?,?,?,?,?,?,?)}";

        try (Connection conn = conexion.getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {

            // Configurar parámetros de entrada
            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getApellidoP());
            stmt.setString(3, emp.getApellidoM());
            stmt.setString(4, emp.getTelefono());
            stmt.setString(5, emp.getDni());
            stmt.setInt(6, idrol);
            stmt.setString(7, cred.getUsername());
            stmt.setString(8, cred.getPassword());

            stmt.registerOutParameter(9, Types.INTEGER);
            stmt.registerOutParameter(10, Types.VARCHAR);
            
            stmt.execute();
            
            int estadoInsert = stmt.getInt(9);
            String mensaje = stmt.getString(10);
            
            return new StoredProcedureResult(estadoInsert, mensaje);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return new StoredProcedureResult(0, "Error de base de datos: " + ex.getMessage());
        }
        
        
        
    }

}
