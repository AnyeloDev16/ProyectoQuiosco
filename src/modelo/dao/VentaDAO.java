package modelo.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.entidad.Venta;

public class VentaDAO {
    
    DatabaseConnector conexion = DatabaseConnector.getConexion();
    
    public OperationResult obtenerListaVentasAdmin(){
        
        String sql = "SELECT [v].venta_id, [e].nombre + \' \' + [e].apellido_paterno + \' \' + [e].apellido_materno, [v].total_venta, [v].fecha_venta FROM Venta [v]"
                + " INNER JOIN Empleado [e] ON [v].empleado_id = [e].empleado_id "
                + " ORDER BY [v].venta_id DESC";
        
        ArrayList<Venta> listaVenta = new ArrayList<>();
        
        try(Connection conn = conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                
                int idVenta = rs.getInt(1);
                String nombreEmpleado = rs.getString(2);
                double totalVenta = rs.getDouble(3);
                LocalDateTime fechaVenta = rs.getTimestamp(4).toLocalDateTime();
                
                Venta v = Venta.builder()
                        .idVenta(idVenta)
                        .nombreEmpleado(nombreEmpleado)
                        .ventaTotal(totalVenta)
                        .ventaFecha(fechaVenta)
                        .build();
                
                listaVenta.add(v);
                
            }
            
            HashMap<String, Object> map = new HashMap<>();
            
            map.put("listaVenta", listaVenta);
            
            if(!listaVenta.isEmpty()){
                return new OperationResult(1, "Se encontraron vetnas", map);
            } else {
                return new OperationResult(-1, "No se encontraron ventas", null);
            }
            
        } catch (SQLException ex) {
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }
        
    }
    
    public OperationResult obtenerListaVentasCajero(){
        
        String sql = "SELECT [v].venta_id, [mp].metodo_pago, [v].fecha_venta, [v].total_venta FROM Venta [v]"
                + " INNER JOIN Pago [p] ON [v].venta_id = [p].venta_id "
                + " INNER JOIN MetodoPago [mp] ON [p].metodo_pago_id = [mp].metodo_pago_id"
                + " WHERE CONVERT(DATE, [v].fecha_venta) = CONVERT(DATE, GETDATE())"
                + " ORDER BY [v].venta_id DESC";
        
        ArrayList<Venta> listaVenta = new ArrayList<>();
        
        try(Connection conn = conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                
                int idVenta = rs.getInt(1);
                String metodoPago = rs.getString(2);
                LocalDateTime fechaVenta = rs.getTimestamp(3).toLocalDateTime();
                double totalVenta = rs.getDouble(4);
                
                Venta v = Venta.builder()
                        .idVenta(idVenta)
                        .metodoPago(metodoPago)
                        .ventaFecha(fechaVenta)
                        .ventaTotal(totalVenta)
                        .build();
                
                listaVenta.add(v);
                
            }
            
            HashMap<String, Object> map = new HashMap<>();
            
            map.put("listaVenta", listaVenta);
            
            if(!listaVenta.isEmpty()){
                return new OperationResult(1, "Se encontraron vetnas", map);
            } else {
                return new OperationResult(-1, "No se encontraron ventas", null);
            }
            
        } catch (SQLException ex) {
            return new OperationResult(0, "Error: " + ex.getMessage(), null);
        }
        
    }
    
}
