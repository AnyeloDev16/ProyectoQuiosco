package vista;

import javax.swing.JOptionPane;
import vista.tipografia.Tipografia;

public class RegistrarProductoFrm extends javax.swing.JDialog{

    Tipografia fuente;
    
    public RegistrarProductoFrm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTipografia();
    }

    private void setTipografia() {
    
        fuente = new Tipografia();
        
        this.jlblTitulo.setFont(fuente.fuente(fuente.ROBOTO, 1, 22));
        
        this.jlblNombre.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblPrecioCompraE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblPrecioVentaE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblImagenProductoE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        
        this.jtxtNombreProducto.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        this.jtxtPrecioCompra.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        this.jtxtPrecioVenta.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));

        this.jbtnSeleccionarImagen.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jbtnRegistrarProducto.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
    }
    

    public void mostrarVentana() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    public void cerrarVentana() {
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPrincipal = new javax.swing.JPanel();
        jpnlTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jpnlRegistro = new javax.swing.JPanel();
        jbtnRegistrarProducto = new javax.swing.JButton();
        jlblNombre = new javax.swing.JLabel();
        jlblPrecioCompraE = new javax.swing.JLabel();
        jlblPrecioVentaE = new javax.swing.JLabel();
        jlblImagenProductoE = new javax.swing.JLabel();
        jtxtNombreProducto = new javax.swing.JTextField();
        jtxtPrecioCompra = new javax.swing.JTextField();
        jtxtPrecioVenta = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jlblProductoImagen = new javax.swing.JLabel();
        jbtnSeleccionarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jpnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlTitulo.setBackground(new java.awt.Color(44, 62, 80));
        jpnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jlblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitulo.setText("REGISTRO DE PRODUCTO NUEVO");
        jpnlTitulo.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 388, 38));

        jpnlPrincipal.add(jpnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        jpnlRegistro.setBackground(new java.awt.Color(52, 73, 94));
        jpnlRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnRegistrarProducto.setBackground(new java.awt.Color(39, 174, 96));
        jbtnRegistrarProducto.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistrarProducto.setText("Registrar Producto");
        jpnlRegistro.add(jbtnRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 280, 52));

        jlblNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblNombre.setText("Nombre Producto:");
        jpnlRegistro.add(jlblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        jlblPrecioCompraE.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblPrecioCompraE.setText("Precio Compra:");
        jpnlRegistro.add(jlblPrecioCompraE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jlblPrecioVentaE.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblPrecioVentaE.setText("Precio Venta:");
        jpnlRegistro.add(jlblPrecioVentaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jlblImagenProductoE.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblImagenProductoE.setText("Imagen del Producto:");
        jpnlRegistro.add(jlblImagenProductoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jtxtNombreProducto.setBackground(new java.awt.Color(236, 240, 241));
        jtxtNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtNombreProducto.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 15, 190, 30));

        jtxtPrecioCompra.setBackground(new java.awt.Color(236, 240, 241));
        jtxtPrecioCompra.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtPrecioCompra.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, 190, 30));

        jtxtPrecioVenta.setBackground(new java.awt.Color(236, 240, 241));
        jtxtPrecioVenta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtPrecioVenta.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 95, 190, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblProductoImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblProductoImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnlRegistro.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 120, 120));

        jbtnSeleccionarImagen.setBackground(new java.awt.Color(39, 174, 96));
        jbtnSeleccionarImagen.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSeleccionarImagen.setText("<html><p>Seleccionar<br>Imagen</p></html>");
        jpnlRegistro.add(jbtnSeleccionarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 100, 52));

        jpnlPrincipal.add(jpnlRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtnRegistrarProducto;
    public javax.swing.JButton jbtnSeleccionarImagen;
    private javax.swing.JLabel jlblImagenProductoE;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblPrecioCompraE;
    private javax.swing.JLabel jlblPrecioVentaE;
    public javax.swing.JLabel jlblProductoImagen;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlRegistro;
    private javax.swing.JPanel jpnlTitulo;
    public javax.swing.JTextField jtxtNombreProducto;
    public javax.swing.JTextField jtxtPrecioCompra;
    public javax.swing.JTextField jtxtPrecioVenta;
    // End of variables declaration//GEN-END:variables

}
