package vista;

public class Boleta extends javax.swing.JFrame {

    public Boleta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jtxaReciboPedido = new javax.swing.JTextArea();
        jbtnImprimirBoleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxaReciboPedido.setEditable(false);
        jtxaReciboPedido.setColumns(20);
        jtxaReciboPedido.setRows(5);
        jScrollPane4.setViewportView(jtxaReciboPedido);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 460));

        jbtnImprimirBoleta.setText("IMPRIMIR");
        getContentPane().add(jbtnImprimirBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 230, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JButton jbtnImprimirBoleta;
    public javax.swing.JTextArea jtxaReciboPedido;
    // End of variables declaration//GEN-END:variables
}
