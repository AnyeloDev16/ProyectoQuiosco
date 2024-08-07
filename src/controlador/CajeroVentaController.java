package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
import vista.CajeroVista;

public class CajeroVentaController implements MouseListener, ListSelectionListener{
 
    CajeroVista vista;
    Employee modelo;

    VentaDAO ventaDAO;
    DetalleVentaDAO detalleVentaDAO;
    PagoDAO pagoDAO;

    DefaultTableModel modeloTabla;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
    
    public CajeroVentaController(CajeroVista vista, Employee modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ventaDAO = new VentaDAO();
        detalleVentaDAO = new DetalleVentaDAO();
        pagoDAO = new PagoDAO();
        modeloTabla = (DefaultTableModel) vista.jtblVentas.getModel();
        cargarVentas();
        this.vista.jtblVentas.getSelectionModel().addListSelectionListener(this);
        this.vista.jbtnImprimir.addMouseListener(this);
        this.vista.jbtnActualizar.addMouseListener(this);
    }

    private void cargarVentas() {
    
        OperationResult or = ventaDAO.obtenerListaVentasCajero();

        if (or.getOperationStatus() != 1) {
            vista.mostrarMensaje(or.getMessage());
            return;
        }

        ArrayList<Venta> listaVenta = (ArrayList<Venta>) or.getData().get("listaVenta");

        listaVenta.stream()
                .forEach(v -> {

                    Object[] row = {
                        v.getIdVenta(),
                        v.getMetodoPago(),
                        v.getVentaFecha().format(dtf),
                        v.getVentaTotal()

                    };

                    modeloTabla.addRow(row);

                });
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getSource() == vista.jbtnImprimir){
            
            String mensaje = vista.jtxtMostrarRecibo.getText();
            
            if(!vista.jtxtMostrarRecibo.getText().isBlank()){
                
                // Imprimir la boleta
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setJobName("Boleta de Compra");

            printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                graphics.drawString(mensaje, 100, 100);

                return Printable.PAGE_EXISTS;
            });

            try {
                if (printerJob.printDialog()) {
                    printerJob.print();
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, "Error al imprimir: " + ex.getMessage());
            }
                
            } else{
                vista.mostrarMensaje("Seleccione una venta para Imprimirlo");
            }
            
        } else if(e.getSource() == vista.jbtnActualizar){
            
            modeloTabla.setRowCount(0);
            cargarVentas();
            
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
