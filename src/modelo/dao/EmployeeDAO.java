package modelo.dao;

import java.sql.*;
import java.util.HashMap;
import modelo.entidad.Employee;

/**
 * Clase DAO para manejar operaciones relacionadas con empleados en la base de
 * datos.
 */
public class EmployeeDAO {

    DatabaseConnector conexion = DatabaseConnector.getConexion();

    /**
     * Método para obtener los datos de un empleado por su ID.
     *
     * @param idEmpleado El ID del empleado.
     * @return El resultado de la operación con los datos del empleado.
     */
    public OperationResult obtenerEmpleado(int idEmpleado) {

        String sql = "SELECT * FROM Empleado WHERE empleado_id = ?;";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEmpleado);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Employee emp = new Employee();

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
            }

        } catch (SQLException ex) {

            return new OperationResult(0, "Error: " + ex.getMessage(), null);

        }

    }

}
