package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
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
     * @param infoDeRetorno El modo de retorno de informacion del empleado
     * @return El resultado de la operación con los datos del empleado.
     */
    public OperationResult obtenerEmpleado(int idEmpleado, RetornoDeInformacionEmpleado infoDeRetorno) {

        String sql = "";

        if (infoDeRetorno.equals(RetornoDeInformacionEmpleado.INFO_COMPLETA)) {
            sql = "SELECT * FROM Empleado WHERE empleado_id = ?;";
        } else if (infoDeRetorno.equals(RetornoDeInformacionEmpleado.DATOS_COMUNICACION)) {
            sql = "SELECT [e].telefono, [e].dni, [e].estado FROM Empleado [e] WHERE empleado_id = ?;";
        }

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEmpleado);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Employee emp = null;

                    if (infoDeRetorno.equals(RetornoDeInformacionEmpleado.INFO_COMPLETA)) {
                        emp = Employee.builder()
                                .idEmpleado(rs.getInt(1))
                                .nombre(rs.getString(2))
                                .apellidoP(rs.getString(3))
                                .apellidoM(rs.getString(4))
                                .telefono(rs.getString(5))
                                .dni(rs.getString(6))
                                .estado(rs.getBoolean(7))
                                .build();
                    } else if (infoDeRetorno.equals(RetornoDeInformacionEmpleado.DATOS_COMUNICACION)) {
                        emp = Employee.builder()
                                .telefono(rs.getString(1))
                                .dni(rs.getString(2))
                                .estado(rs.getBoolean(3))
                                .build();
                    }

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

    public OperationResult obtenerListaEmpleadoConRol() {

        ArrayList<Employee> listaEmpleado = new ArrayList<>();

        String sql = "SELECT [e].empleado_id, [e].nombre, [e].apellido_paterno, [e].apellido_materno, [r].nombre_rol FROM Empleado [e]"
                + " INNER JOIN Empleado_Rol [er] ON [e].empleado_id = [er].empleado_id"
                + " INNER JOIN ROL [r] ON [er].rol_id = [r].rol_id"
                + " WHERE [e].empleado_id <> 1";

        try (Connection conn = conexion.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Employee emp = Employee.builder()
                        .idEmpleado(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .apellidoP(rs.getString(3))
                        .apellidoM(rs.getString(4))
                        .rol(rs.getString(5))
                        .build();

                listaEmpleado.add(emp);

            }

            HashMap<String, Object> map = new HashMap<>();

            map.put("ListaEmpleado", listaEmpleado);

            if (listaEmpleado.isEmpty()) {
                return new OperationResult(-1, "No se encontro ningun empleado", map);
            } else {
                return new OperationResult(1, "Se encontro registro de empleados", map);
            }

        } catch (SQLException ex) {

            return new OperationResult(0, "Error: " + ex.getMessage(), null);

        }

    }

    public OperationResult cambiarEstadoEmpleado(int idEmpleado) {
        String sql = "UPDATE Empleado SET estado = (1 - estado) OUTPUT inserted.estado WHERE empleado_id = ?";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmpleado);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                    boolean nuevoEstado = rs.getBoolean(1); // Captura el valor de inserted.estado

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("nuevoEstado", nuevoEstado);

                    return new OperationResult(1, "Estado del empleado actualizado correctamente", map);
                } else {
                    return new OperationResult(-1, "Empleado no encontrado", null);
                }
            }
        } catch (SQLException ex) {
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }
    }

}
