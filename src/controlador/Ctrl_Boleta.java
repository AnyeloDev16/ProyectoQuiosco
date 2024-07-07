package controlador;

import vista.Boleta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

public class Ctrl_Boleta implements ActionListener{
    
    Boleta vista;
    String texto;

    public Ctrl_Boleta(Boleta vista, String texto) {
        this.vista = vista;
        this.texto = texto;
        this.vista.jtxaReciboPedido.append(texto);
        this.vista.jbtnImprimirBoleta.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnImprimirBoleta) {
            // Imprimir la boleta
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setJobName("Boleta de Compra");

            printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                graphics.drawString(texto, 100, 100); // Ajusta las coordenadas para la impresión

                return Printable.PAGE_EXISTS;
            });

            try {
                if (printerJob.printDialog()) {
                    printerJob.print();
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, "Error al imprimir: " + ex.getMessage());
            }
        }
    }

    
    
    
    
}
