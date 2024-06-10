package vista;

public class AdministradorVista extends javax.swing.JFrame {

    public AdministradorVista() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPrincipal = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jpnlBarraOpciones = new javax.swing.JPanel();
        jlblLogoTienda = new javax.swing.JLabel();
        jlblEmpleadoNombre = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jbtnInicio = new javax.swing.JButton();
        jbtnVentas = new javax.swing.JButton();
        jbtnEmpleados = new javax.swing.JButton();
        jbtnProducto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jbtnCerrarSesion = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jpnlBarraTitulo = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jlblMinimizar = new javax.swing.JLabel();
        jlblCerrar = new javax.swing.JLabel();
        jlblTitulo = new javax.swing.JLabel();
        jtpnlVentanas = new javax.swing.JTabbedPane();
        jpnlInicio = new javax.swing.JPanel();
        jpnlVentas = new javax.swing.JPanel();
        jpnlEmpleado = new javax.swing.JPanel();
        jpnlProducto = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setResizable(false);

        jpnlPrincipal.setMaximumSize(new java.awt.Dimension(1200, 700));
        jpnlPrincipal.setMinimumSize(new java.awt.Dimension(1200, 700));
        jpnlPrincipal.setRequestFocusEnabled(false);
        jpnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setOpaque(true);
        jpnlPrincipal.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1, 700));

        jSeparator11.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator11.setOpaque(true);
        jpnlPrincipal.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 1, 700));

        jSeparator5.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator5.setOpaque(true);
        jpnlPrincipal.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 1));

        jSeparator12.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator12.setOpaque(true);
        jpnlPrincipal.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 1200, 1));

        jpnlBarraOpciones.setBackground(new java.awt.Color(41, 87, 164));
        jpnlBarraOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblLogoTienda.setOpaque(true);
        jpnlBarraOpciones.add(jlblLogoTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 110));

        jlblEmpleadoNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlblEmpleadoNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblEmpleadoNombre.setText("User name");
        jpnlBarraOpciones.add(jlblEmpleadoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, -1));
        jpnlBarraOpciones.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 10));

        jbtnInicio.setBackground(new java.awt.Color(255, 255, 255));
        jbtnInicio.setForeground(new java.awt.Color(102, 102, 102));
        jbtnInicio.setText("Inicio");
        jpnlBarraOpciones.add(jbtnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 50));

        jbtnVentas.setBackground(new java.awt.Color(255, 255, 255));
        jbtnVentas.setForeground(new java.awt.Color(102, 102, 102));
        jbtnVentas.setText("Ventas");
        jpnlBarraOpciones.add(jbtnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 50));

        jbtnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        jbtnEmpleados.setForeground(new java.awt.Color(102, 102, 102));
        jbtnEmpleados.setText("Empleados");
        jpnlBarraOpciones.add(jbtnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 50));

        jbtnProducto.setBackground(new java.awt.Color(255, 255, 255));
        jbtnProducto.setForeground(new java.awt.Color(102, 102, 102));
        jbtnProducto.setText("Productos");
        jpnlBarraOpciones.add(jbtnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 130, 50));
        jpnlBarraOpciones.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 585, 110, 10));

        jbtnCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jbtnCerrarSesion.setForeground(new java.awt.Color(102, 102, 102));
        jbtnCerrarSesion.setText("Cerrar Sesión");
        jpnlBarraOpciones.add(jbtnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 605, 130, 50));

        jSeparator3.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setOpaque(true);
        jpnlBarraOpciones.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 0, 1, 700));

        jSeparator7.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setOpaque(true);
        jpnlBarraOpciones.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 1, 700));

        jSeparator10.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator10.setOpaque(true);
        jpnlBarraOpciones.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 699, 150, 1));

        jpnlPrincipal.add(jpnlBarraOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 150, 665));

        jpnlBarraTitulo.setBackground(new java.awt.Color(45, 110, 208));
        jpnlBarraTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator6.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator6.setOpaque(true);
        jpnlBarraTitulo.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 1200, 1));

        jlblMinimizar.setBackground(new java.awt.Color(45, 110, 208));
        jlblMinimizar.setForeground(new java.awt.Color(51, 51, 51));
        jlblMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMinimizar.setText("-");
        jlblMinimizar.setOpaque(true);
        jpnlBarraTitulo.add(jlblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 50, 35));

        jlblCerrar.setBackground(new java.awt.Color(45, 110, 208));
        jlblCerrar.setForeground(new java.awt.Color(51, 51, 51));
        jlblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblCerrar.setText("X");
        jlblCerrar.setOpaque(true);
        jpnlBarraTitulo.add(jlblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 50, 35));

        jlblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jlblTitulo.setText("Sistema de ventas Quiosco Universidad César Vallejo");
        jpnlBarraTitulo.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 300, 35));

        jpnlPrincipal.add(jpnlBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 35));

        jpnlInicio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnlInicioLayout = new javax.swing.GroupLayout(jpnlInicio);
        jpnlInicio.setLayout(jpnlInicioLayout);
        jpnlInicioLayout.setHorizontalGroup(
            jpnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jpnlInicioLayout.setVerticalGroup(
            jpnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        jtpnlVentanas.addTab("Inicio", jpnlInicio);

        jpnlVentas.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnlVentasLayout = new javax.swing.GroupLayout(jpnlVentas);
        jpnlVentas.setLayout(jpnlVentasLayout);
        jpnlVentasLayout.setHorizontalGroup(
            jpnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jpnlVentasLayout.setVerticalGroup(
            jpnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        jtpnlVentanas.addTab("Ventas", jpnlVentas);

        jpnlEmpleado.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnlEmpleadoLayout = new javax.swing.GroupLayout(jpnlEmpleado);
        jpnlEmpleado.setLayout(jpnlEmpleadoLayout);
        jpnlEmpleadoLayout.setHorizontalGroup(
            jpnlEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jpnlEmpleadoLayout.setVerticalGroup(
            jpnlEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        jtpnlVentanas.addTab("Empleado", jpnlEmpleado);

        jpnlProducto.setBackground(new java.awt.Color(239, 239, 239));

        javax.swing.GroupLayout jpnlProductoLayout = new javax.swing.GroupLayout(jpnlProducto);
        jpnlProducto.setLayout(jpnlProductoLayout);
        jpnlProductoLayout.setHorizontalGroup(
            jpnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jpnlProductoLayout.setVerticalGroup(
            jpnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        jtpnlVentanas.addTab("Producto", jpnlProducto);

        jpnlPrincipal.add(jtpnlVentanas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1050, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    public javax.swing.JButton jbtnCerrarSesion;
    public javax.swing.JButton jbtnEmpleados;
    public javax.swing.JButton jbtnInicio;
    public javax.swing.JButton jbtnProducto;
    public javax.swing.JButton jbtnVentas;
    public javax.swing.JLabel jlblCerrar;
    public javax.swing.JLabel jlblEmpleadoNombre;
    public javax.swing.JLabel jlblLogoTienda;
    public javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpnlBarraOpciones;
    private javax.swing.JPanel jpnlBarraTitulo;
    private javax.swing.JPanel jpnlEmpleado;
    private javax.swing.JPanel jpnlInicio;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlProducto;
    private javax.swing.JPanel jpnlVentas;
    public javax.swing.JTabbedPane jtpnlVentanas;
    // End of variables declaration//GEN-END:variables
}
