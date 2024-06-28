package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.dao.OperationResult;
import modelo.dao.VentaDAO;
import modelo.entidad.Employee;
import modelo.entidad.Venta;
import vista.AdministradorVista;

public class AdmVentaController implements MouseListener {

    AdministradorVista vista;
    Employee modelo;

    VentaDAO ventaDAO;

    DefaultTableModel modeloTabla;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

    public AdmVentaController(AdministradorVista vista, Employee modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ventaDAO = new VentaDAO();
        modeloTabla = (DefaultTableModel) vista.jtblVentas.getModel();
        cargarVentas();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    private void cargarVentas() {

        OperationResult or = ventaDAO.obtenerListaVentasAdmin();

        if (or.getOperationStatus() != 1) {
            vista.mostrarMensaje(or.getMessage());
            return;
        }

        ArrayList<Venta> listaVenta = (ArrayList<Venta>) or.getData().get("listaVenta");

        listaVenta.stream()
                .forEach(v -> {

                    Object[] row = {
                        v.getIdVenta(),
                        v.getNombreEmpleado(),
                        v.getVentaFecha().format(dtf),
                        v.getVentaTotal()

                    };

                    modeloTabla.addRow(row);

                });

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
