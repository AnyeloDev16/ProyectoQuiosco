package modelo.dao;

import java.sql.*;
import java.util.HashMap;

/**
 * Clase DAO para manejar operaciones relacionadas con credenciales de usuario
 * en la base de datos.
 */
public class CredentialDAO {

    DatabaseConnector conexion = DatabaseConnector.getConexion();

    /**
     * Método para obtener la contraseña asociada a un usuario dado su nombre de
     * usuario.
     *
     * @param username El nombre de usuario.
     * @return El resultado de la operación con la contraseña y el ID del
     * empleado.
     */
    public OperationResult obtenerContrasenia(String username) {

        String sql = "SELECT empleado_id, password FROM Credencial WHERE username = ?;";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    int emp_id = rs.getInt(1);
                    String pass = rs.getString(2);

                    HashMap<String, Object> map = new HashMap<>();

                    map.put("empleado_id", emp_id);
                    map.put("password", pass);

                    return new OperationResult(1, "Username encontrado", map);

                } else {
                    return new OperationResult(-1, "Username no encontrado", null);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }

    }

}
