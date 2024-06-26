package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.entidad.MetodoDePago;

public class MetodoDePagoDAO {
    
    DatabaseConnector conexion = DatabaseConnector.getConexion();
    
    public OperationResult obtenerListaProductos() {

        ArrayList<MetodoDePago> listaMetodoPago = new ArrayList<>();
        String sql = "SELECT * FROM MetodoPago ORDER BY metodo_pago_id ASC";

        try (Connection conn = conexion.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                MetodoDePago metodoPago = new MetodoDePago(rs.getInt(1), rs.getString(2));

                listaMetodoPago.add(metodoPago);

            }

            HashMap<String, Object> map = new HashMap<>();

            map.put("ListaMetodosDePago", listaMetodoPago);

            if (listaMetodoPago.isEmpty()) {
                return new OperationResult(-1, "No se encontro ningun metodo de Pago", map);
            } else {
                return new OperationResult(1, "Se encontro metodow de Pago", map);
            }

        } catch (SQLException ex) {

            return new OperationResult(0, "Error: " + ex.getMessage(), null);

        }

    }
    
}
