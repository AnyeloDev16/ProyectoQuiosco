package vista;

import java.awt.geom.RoundRectangle2D;
import vista.tipografia.Tipografia;

public class AdministradorVista extends javax.swing.JFrame {

    Tipografia fuente;
    
    public AdministradorVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),30,30));
        this.setTipografia();
        this.jtblEmpleados.setDefaultEditor(Object.class, null);
        this.jtblEmpleados.setRowSelectionAllowed(true);
    }

    private void setTipografia(){
        fuente = new Tipografia();
        jlblTitulo.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jlblEmpleadoNombre.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnInicio.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnVentas.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnEmpleados.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnProducto.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnCerrarSesion.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPrincipal = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
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
        jlblMinimizar = new javax.swing.JLabel();
        jlblCerrar = new javax.swing.JLabel();
        jlblTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtpnlVentanas = new javax.swing.JTabbedPane();
        jpnlInicio = new javax.swing.JPanel();
        jpnlVentas = new javax.swing.JPanel();
        jpnlEmpleado = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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

        jSeparator6.setBackground(new java.awt.Color(28, 47, 79));
        jSeparator6.setOpaque(true);
        jpnlPrincipal.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 1200, 1));

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
        jpnlBarraTitulo.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 310, 35));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/LogoUcv.png"))); // NOI18N
        jpnlBarraTitulo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2, 30, 30));

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
        jpnlEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnlEmpleado.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 10, 550));

        jScrollPane1.setBorder(null);

        jtblEmpleados.setBackground(new java.awt.Color(220, 220, 220));
        jtblEmpleados.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jtblEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        jtblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Empleado ID", "Rol", "Nombre Completo"
            }
        ));
        jtblEmpleados.setFocusable(false);
        jtblEmpleados.setOpaque(false);
        jtblEmpleados.setRequestFocusEnabled(false);
        jtblEmpleados.getTableHeader().setResizingAllowed(false);
        jtblEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblEmpleados);

        jpnlEmpleado.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 530));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Información completa del empleado:");
        jpnlEmpleado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 340, 30));

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jpnlEmpleado.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 450, 260));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("ADMINISTRACIÓN DE EMPLEADOS:");
        jpnlEmpleado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 420, 40));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cambiar estado de Empleado");
        jpnlEmpleado.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 190, 50));

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Registrar nuevo Empleado");
        jpnlEmpleado.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 190, 50));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JSeparator jSeparator8;
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
    private javax.swing.JTable jtblEmpleados;
    public javax.swing.JTabbedPane jtpnlVentanas;
    // End of variables declaration//GEN-END:variables
}
