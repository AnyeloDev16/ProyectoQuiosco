package modelo.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.HashMap;

/**
 * Clase DAO para manejar operaciones relacionadas con roles de empleado en la
 * base de datos.
 */
public class RoleDAO {

    DatabaseConnector conexion = DatabaseConnector.getConexion();

    /**
     * Método para obtener el rol de un empleado por su ID.
     *
     * @param idemp El ID del empleado.
     * @return El resultado de la operación con el ID del rol.
     */
    public OperationResult obtenerRol(int idemp) {

        String sql = "SELECT rol_id FROM Empleado_Rol WHERE empleado_id = ?;";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idemp);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    int rol_id = rs.getInt(1);

                    HashMap<String, Object> map = new HashMap<>();

                    map.put("rol_id", rol_id);

                    return new OperationResult(1, "Rol encontrado", map);

                } else {
                    return new OperationResult(-1, "Rol no encontrado", null);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }

    }

}
