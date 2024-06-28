package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.dao.DetalleVentaDAO;
import modelo.dao.OperationResult;
import modelo.dao.PagoDAO;
import modelo.dao.VentaDAO;
import modelo.entidad.DetalleVenta;
import modelo.entidad.Employee;
import modelo.entidad.Pago;
import modelo.entidad.Venta;
import vista.AdministradorVista;

public class AdmVentaController implements MouseListener, ListSelectionListener {

    AdministradorVista vista;
    Employee modelo;

    VentaDAO ventaDAO;
    DetalleVentaDAO detalleVentaDAO;
    PagoDAO pagoDAO;

    DefaultTableModel modeloTabla;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

    public AdmVentaController(AdministradorVista vista, Employee modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ventaDAO = new VentaDAO();
        detalleVentaDAO = new DetalleVentaDAO();
        pagoDAO = new PagoDAO();
        modeloTabla = (DefaultTableModel) vista.jtblVentas.getModel();
        cargarVentas();
        this.vista.jtblVentas.getSelectionModel().addListSelectionListener(this);
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
    public void valueChanged(ListSelectionEvent e) {

        if (e.getValueIsAdjusting()) {

            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                int selectedRow = lsm.getMinSelectionIndex();

                if (selectedRow != -1) {

                    if (lsm == vista.jtblVentas.getSelectionModel()) {

                        int idVen = (Integer) vista.jtblVentas.getValueAt(selectedRow, 0);

                        OperationResult or1 = detalleVentaDAO.obtenerListaDetalleVenta(idVen);

                        ArrayList<DetalleVenta> listaDV = (ArrayList<DetalleVenta>) or1.getData().get("ListaDetalleVenta");

                        OperationResult or2 = pagoDAO.obtenerPago(idVen);

                        Pago pago = (Pago) or2.getData().get("Pago");

                        vista.jtxtMostrarRecibo.setText(formatoRecibo(listaDV, pago));

                    }

                }
            }
        }

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

    private String formatoRecibo(ArrayList<DetalleVenta> listaDV, Pago pago) {
        StringBuilder recibo = new StringBuilder();
        int rowSelected = vista.jtblVentas.getSelectedRow();

        // Ancho del recibo
        int anchoRecibo = 60;

        // Título del recibo
        recibo.append("*".repeat(anchoRecibo)).append("\n");
        recibo.append(String.format("%" + (anchoRecibo / 2 + 9) + "s\n", "Quiosco UCV - Recibo"));
        recibo.append("*".repeat(anchoRecibo)).append("\n\n");

        // Información básica de la venta
        String ventaID = vista.jtblVentas.getValueAt(rowSelected, 0).toString();
        String empleado = vista.jtblVentas.getValueAt(rowSelected, 1).toString();
        String fecha = vista.jtblVentas.getValueAt(rowSelected, 2).toString();

        // Alineación de los dos puntos con espacios adicionales
        recibo.append(String.format("%-12s: %s\n", "VentaID", ventaID));
        recibo.append(String.format("%-12s: %s\n", "Empleado", empleado));
        recibo.append(String.format("%-12s: %s\n\n", "Fecha", fecha));

        // Separador de Detalle Venta
        recibo.append("*".repeat(anchoRecibo)).append("\n");
        recibo.append(String.format("%" + (anchoRecibo / 2 + 4) + "s\n", "Detalle Venta"));
        recibo.append("*".repeat(anchoRecibo)).append("\n\n");

        // Método de pago
        recibo.append(String.format("Metodo de Pago: %s\n\n", pago.getMetodoDePago().getMetodoPago()));

        // Encabezados de las columnas
        recibo.append(String.format("%-30s %10s %10s\n", "Producto", "Cantidad", "Subtotal"));

        // Detalles de la venta utilizando streams
        listaDV.stream()
                .map(detalle -> String.format("%-30s %10d %10.2f\n",
                detalle.getNombreProducto(),
                detalle.getCantidad(),
                detalle.getSubTotal()))
                .forEach(recibo::append);

        // Total Pago, Cancelado con y Vuelto
        double totalPago = Double.parseDouble(vista.jtblVentas.getValueAt(rowSelected, 3).toString());
        recibo.append("\n").append(String.format("%-20s %30.2f\n", "Total Pago:", totalPago));
        recibo.append(String.format("%-20s %30.2f\n", "Cancelado con:", pago.getTotalCancelado()));
        recibo.append(String.format("%-20s %30.2f\n", "Vuelto:", pago.getVuelto())).append("\n\n");

        recibo.append("*".repeat(anchoRecibo)).append("\n");

        return recibo.toString();
    }

}
