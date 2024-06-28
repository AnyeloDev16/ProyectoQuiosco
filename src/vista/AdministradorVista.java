package vista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import vista.tipografia.Tipografia;

public class AdministradorVista extends javax.swing.JFrame implements MouseListener {

    Tipografia fuente;

    public AdministradorVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        this.setEstiloTabla();
        this.setTipografia();      
        this.jlblCerrar.addMouseListener(this);
        this.jlblMinimizar.addMouseListener(this);
    }

    private void setTipografia() {
        fuente = new Tipografia();
        jlblTitulo.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jlblEmpleadoNombre.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnInicio.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnVentas.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnEmpleados.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnProducto.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnCerrarSesion.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        //Empleado
        jlblTituloEmpleado.setFont(fuente.fuente(fuente.ROBOTO, 1, 30));
        jtblEmpleados.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        jlblInfEmpleado.setFont(fuente.fuente(fuente.ROBOTO, 1, 24));
        jlblEstadoE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblNombreCE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblRolE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblIDE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblDniE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblTelefonoE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblUsernameE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblPassE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnCambiarEstado.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnRegistrarNuevoEmpleado.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblEstadoI.setFont(fuente.fuente(fuente.ROBOTO, 1, 24));
        jlblNombreCI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblRolI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblDniI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblTelefonoI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblIDI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblUsernameI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        //Producto
        jlblTituloProducto.setFont(fuente.fuente(fuente.ROBOTO, 1, 30));
        jlblInfProducto.setFont(fuente.fuente(fuente.ROBOTO, 1, 24));
        jlblNombreP.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblNombreProductoI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblPrecioCompraE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblPrecioCompra.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblPrecioVentaE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblPrecioVenta.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblCantidad.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblStockE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jlblProductoImgE.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnCambiarPrecioCompra.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnCambiarPrecioVenta.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnCambiarStock.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnCambiarImagen.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnRegistrarNuevoProducto.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnEliminarProducto.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jtblProductos.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        jtblVentas.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
    }

    private void setEstiloTabla() {
        this.jtblEmpleados.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.jtblEmpleados.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.jtblEmpleados.getColumnModel().getColumn(2).setPreferredWidth(250);

        this.jtblProductos.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.jtblProductos.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.jtblProductos.getColumnModel().getColumn(2).setPreferredWidth(70);

        this.jtblVentas.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.jtblVentas.getColumnModel().getColumn(1).setPreferredWidth(190);
        this.jtblVentas.getColumnModel().getColumn(2).setPreferredWidth(180);
        this.jtblVentas.getColumnModel().getColumn(3).setPreferredWidth(100);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jtblVentas.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
        this.jtblEmpleados.setDefaultEditor(Object.class, null);
        this.jtblEmpleados.setRowSelectionAllowed(true);
        this.jtblEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jtblProductos.setDefaultEditor(Object.class, null);
        this.jtblProductos.setRowSelectionAllowed(true);
        this.jtblProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jtblVentas.setDefaultEditor(Object.class, null);
        this.jtblVentas.setRowSelectionAllowed(true);
        this.jtblVentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == this.jlblCerrar) {
            this.jlblCerrar.setBackground(new Color(215, 0, 0));
        }
        if (e.getSource() == this.jlblMinimizar) {
            this.jlblMinimizar.setBackground(new Color(38, 75, 130));
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == this.jlblCerrar) {
            this.jlblCerrar.setBackground(Color.red);
        }
        if (e.getSource() == this.jlblMinimizar) {
            this.jlblMinimizar.setBackground(new Color(41, 87, 164));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == this.jlblCerrar) {
            this.jlblCerrar.setBackground(new Color(45, 110, 208));
        }
        if (e.getSource() == this.jlblMinimizar) {
            this.jlblMinimizar.setBackground(new Color(45, 110, 208));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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

    public void minimizarVentana() {
        this.setState(JFrame.ICONIFIED);
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
        jSeparator13 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblVentas = new javax.swing.JTable();
        jlblInfEmpleado1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlblEstadoI1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jlblTituloEmpleado1 = new javax.swing.JLabel();
        jpnlEmpleado = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEmpleados = new javax.swing.JTable();
        jlblInfEmpleado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlblDniE = new javax.swing.JLabel();
        jlblEstadoE = new javax.swing.JLabel();
        jlblNombreCE = new javax.swing.JLabel();
        jlblIDE = new javax.swing.JLabel();
        jlblTelefonoE = new javax.swing.JLabel();
        jlblTelefonoI = new javax.swing.JLabel();
        jlblNombreCI = new javax.swing.JLabel();
        jlblRolI = new javax.swing.JLabel();
        jlblDniI = new javax.swing.JLabel();
        jlblEstadoI = new javax.swing.JLabel();
        jlblPassE = new javax.swing.JLabel();
        jlblUsernameE = new javax.swing.JLabel();
        jlblUsernameI = new javax.swing.JLabel();
        jbtnCambiarEstado = new javax.swing.JButton();
        jbtnCambiarContrasenia = new javax.swing.JButton();
        jlblRolE = new javax.swing.JLabel();
        jlblIDI = new javax.swing.JLabel();
        jlblTituloEmpleado = new javax.swing.JLabel();
        jbtnRegistrarNuevoEmpleado = new javax.swing.JButton();
        jpnlProducto = new javax.swing.JPanel();
        jlblTituloProducto = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblProductos = new javax.swing.JTable();
        jlblInfProducto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblNombreP = new javax.swing.JLabel();
        jlblProductoImgE = new javax.swing.JLabel();
        jlblNombreProductoI = new javax.swing.JLabel();
        jlblPrecioVenta = new javax.swing.JLabel();
        jlblCantidad = new javax.swing.JLabel();
        jbtnCambiarPrecioCompra = new javax.swing.JButton();
        jlblPrecioCompra = new javax.swing.JLabel();
        jlblPrecioCompraE = new javax.swing.JLabel();
        jlblPrecioVentaE = new javax.swing.JLabel();
        jlblStockE = new javax.swing.JLabel();
        jbtnCambiarImagen = new javax.swing.JButton();
        jbtnCambiarStock = new javax.swing.JButton();
        jbtnCambiarPrecioVenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlblProductoImg = new javax.swing.JLabel();
        jlblIDProductoE = new javax.swing.JLabel();
        jlblIDProductoI = new javax.swing.JLabel();
        jbtnEliminarProducto = new javax.swing.JButton();
        jbtnRegistrarNuevoProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jlblLogoTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/LogoPerfil (1).png"))); // NOI18N
        jlblLogoTienda.setOpaque(true);
        jpnlBarraOpciones.add(jlblLogoTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 108, 88));

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
        jpnlVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnlVentas.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 10, 550));

        jScrollPane3.setBorder(null);

        jtblVentas.setBackground(new java.awt.Color(220, 220, 220));
        jtblVentas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jtblVentas.setForeground(new java.awt.Color(0, 0, 0));
        jtblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Venta ID", "Nombre Empleado", "Fecha", "Total de Venta"
            }
        ));
        jtblVentas.setFocusable(false);
        jtblVentas.setOpaque(false);
        jtblVentas.setRequestFocusEnabled(false);
        jtblVentas.getTableHeader().setResizingAllowed(false);
        jtblVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtblVentas);

        jpnlVentas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 550, 530));

        jlblInfEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlblInfEmpleado1.setForeground(new java.awt.Color(29, 53, 87));
        jlblInfEmpleado1.setText("Recibo de la Venta:");
        jpnlVentas.add(jlblInfEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 380, 30));

        jPanel4.setBackground(new java.awt.Color(211, 211, 211));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblEstadoI1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblEstadoI1.setForeground(new java.awt.Color(0, 0, 0));
        jlblEstadoI1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jlblEstadoI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 25, 140, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 390));

        jpnlVentas.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 390, 430));

        jlblTituloEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jlblTituloEmpleado1.setForeground(new java.awt.Color(29, 53, 87));
        jlblTituloEmpleado1.setText("HISTORIAL DE VENTAS:");
        jpnlVentas.add(jlblTituloEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 430, 40));

        jtpnlVentanas.addTab("Ventas", jpnlVentas);

        jpnlEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        jpnlEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnlEmpleado.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 10, 550));

        jScrollPane1.setBorder(null);

        jtblEmpleados.setBackground(new java.awt.Color(220, 220, 220));
        jtblEmpleados.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jtblEmpleados.setForeground(new java.awt.Color(0, 0, 0));
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

        jpnlEmpleado.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 530));

        jlblInfEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlblInfEmpleado.setForeground(new java.awt.Color(29, 53, 87));
        jlblInfEmpleado.setText("Información completa del empleado:");
        jpnlEmpleado.add(jlblInfEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 440, 30));

        jPanel1.setBackground(new java.awt.Color(211, 211, 211));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblDniE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblDniE.setForeground(new java.awt.Color(51, 51, 51));
        jlblDniE.setText("DNI:");
        jPanel1.add(jlblDniE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jlblEstadoE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblEstadoE.setForeground(new java.awt.Color(51, 51, 51));
        jlblEstadoE.setText("Estado:");
        jPanel1.add(jlblEstadoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jlblNombreCE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblNombreCE.setForeground(new java.awt.Color(51, 51, 51));
        jlblNombreCE.setText("Nombre completo:");
        jPanel1.add(jlblNombreCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jlblIDE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblIDE.setForeground(new java.awt.Color(51, 51, 51));
        jlblIDE.setText("ID:");
        jPanel1.add(jlblIDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jlblTelefonoE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblTelefonoE.setForeground(new java.awt.Color(51, 51, 51));
        jlblTelefonoE.setText("Teléfono:");
        jPanel1.add(jlblTelefonoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jlblTelefonoI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblTelefonoI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jlblTelefonoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 110, 22));

        jlblNombreCI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblNombreCI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jlblNombreCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 270, 22));

        jlblRolI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblRolI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jlblRolI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 110, 22));

        jlblDniI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblDniI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jlblDniI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 110, 22));

        jlblEstadoI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblEstadoI.setForeground(new java.awt.Color(0, 0, 0));
        jlblEstadoI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlblEstadoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 25, 140, 30));

        jlblPassE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblPassE.setForeground(new java.awt.Color(51, 51, 51));
        jlblPassE.setText("Password:");
        jPanel1.add(jlblPassE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        jlblUsernameE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblUsernameE.setForeground(new java.awt.Color(51, 51, 51));
        jlblUsernameE.setText("Username:");
        jPanel1.add(jlblUsernameE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jlblUsernameI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblUsernameI.setForeground(new java.awt.Color(0, 0, 0));
        jlblUsernameI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlblUsernameI, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 140, 22));

        jbtnCambiarEstado.setBackground(new java.awt.Color(76, 175, 80));
        jbtnCambiarEstado.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnCambiarEstado.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambiarEstado.setText("Cambiar estado");
        jPanel1.add(jbtnCambiarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 25, 160, 30));

        jbtnCambiarContrasenia.setBackground(new java.awt.Color(76, 175, 80));
        jbtnCambiarContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnCambiarContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambiarContrasenia.setText("Cambiar contraseña");
        jPanel1.add(jbtnCambiarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 190, 30));

        jlblRolE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblRolE.setForeground(new java.awt.Color(51, 51, 51));
        jlblRolE.setText("Rol:");
        jPanel1.add(jlblRolE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jlblIDI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblIDI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jlblIDI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 110, 22));

        jpnlEmpleado.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 480, 310));

        jlblTituloEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jlblTituloEmpleado.setForeground(new java.awt.Color(29, 53, 87));
        jlblTituloEmpleado.setText("ADMINISTRACIÓN DE EMPLEADOS:");
        jpnlEmpleado.add(jlblTituloEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 630, 40));

        jbtnRegistrarNuevoEmpleado.setBackground(new java.awt.Color(51, 153, 255));
        jbtnRegistrarNuevoEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnRegistrarNuevoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistrarNuevoEmpleado.setText("Registrar nuevo Empleado");
        jpnlEmpleado.add(jbtnRegistrarNuevoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, 360, 50));

        jtpnlVentanas.addTab("Empleado", jpnlEmpleado);

        jpnlProducto.setBackground(new java.awt.Color(255, 255, 255));
        jpnlProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTituloProducto.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jlblTituloProducto.setForeground(new java.awt.Color(29, 53, 87));
        jlblTituloProducto.setText("ADMINISTRACIÓN DE PRODUCTOS:");
        jpnlProducto.add(jlblTituloProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 540, 40));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnlProducto.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 10, 550));

        jScrollPane2.setBorder(null);

        jtblProductos.setBackground(new java.awt.Color(220, 220, 220));
        jtblProductos.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jtblProductos.setForeground(new java.awt.Color(0, 0, 0));
        jtblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Producto ID", "Nombre del Producto", "Cantidad"
            }
        ));
        jtblProductos.setFocusable(false);
        jtblProductos.setOpaque(false);
        jtblProductos.setRequestFocusEnabled(false);
        jtblProductos.getTableHeader().setResizingAllowed(false);
        jtblProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtblProductos);

        jpnlProducto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, 530));

        jlblInfProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlblInfProducto.setForeground(new java.awt.Color(29, 53, 87));
        jlblInfProducto.setText("Información del Producto:");
        jpnlProducto.add(jlblInfProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 440, 30));

        jPanel2.setBackground(new java.awt.Color(211, 211, 211));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblNombreP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblNombreP.setForeground(new java.awt.Color(51, 51, 51));
        jlblNombreP.setText("Producto nombre:");
        jPanel2.add(jlblNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jlblProductoImgE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblProductoImgE.setForeground(new java.awt.Color(51, 51, 51));
        jlblProductoImgE.setText("Imagen del Producto:");
        jPanel2.add(jlblProductoImgE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jlblNombreProductoI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblNombreProductoI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jlblNombreProductoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 230, 22));

        jlblPrecioVenta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblPrecioVenta.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jlblPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 80, 22));

        jlblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblCantidad.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jlblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 80, 22));

        jbtnCambiarPrecioCompra.setBackground(new java.awt.Color(76, 175, 80));
        jbtnCambiarPrecioCompra.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnCambiarPrecioCompra.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambiarPrecioCompra.setText("Cambiar Precio");
        jPanel2.add(jbtnCambiarPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 95, 170, 30));

        jlblPrecioCompra.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblPrecioCompra.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jlblPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, 22));

        jlblPrecioCompraE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblPrecioCompraE.setForeground(new java.awt.Color(51, 51, 51));
        jlblPrecioCompraE.setText("Precio de Compra:");
        jPanel2.add(jlblPrecioCompraE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jlblPrecioVentaE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblPrecioVentaE.setForeground(new java.awt.Color(51, 51, 51));
        jlblPrecioVentaE.setText("Precio de Venta:");
        jPanel2.add(jlblPrecioVentaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jlblStockE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblStockE.setForeground(new java.awt.Color(51, 51, 51));
        jlblStockE.setText("Cantidad:");
        jPanel2.add(jlblStockE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jbtnCambiarImagen.setBackground(new java.awt.Color(76, 175, 80));
        jbtnCambiarImagen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnCambiarImagen.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambiarImagen.setText("Cambiar Imagen");
        jPanel2.add(jbtnCambiarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 305, 170, 30));

        jbtnCambiarStock.setBackground(new java.awt.Color(76, 175, 80));
        jbtnCambiarStock.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnCambiarStock.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambiarStock.setText("Cambiar el Stock");
        jPanel2.add(jbtnCambiarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 175, 170, 30));

        jbtnCambiarPrecioVenta.setBackground(new java.awt.Color(76, 175, 80));
        jbtnCambiarPrecioVenta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnCambiarPrecioVenta.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambiarPrecioVenta.setText("Cambiar Precio");
        jPanel2.add(jbtnCambiarPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 135, 170, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblProductoImg, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblProductoImg, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, 120));

        jlblIDProductoE.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblIDProductoE.setForeground(new java.awt.Color(51, 51, 51));
        jlblIDProductoE.setText("ID:");
        jPanel2.add(jlblIDProductoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jlblIDProductoI.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblIDProductoI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jlblIDProductoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 80, 22));

        jpnlProducto.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 480, 410));

        jbtnEliminarProducto.setBackground(new java.awt.Color(51, 153, 255));
        jbtnEliminarProducto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        jbtnEliminarProducto.setText("Eliminar Producto");
        jpnlProducto.add(jbtnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, 190, 50));

        jbtnRegistrarNuevoProducto.setBackground(new java.awt.Color(51, 153, 255));
        jbtnRegistrarNuevoProducto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnRegistrarNuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistrarNuevoProducto.setText("Registrar nuevo Producto");
        jpnlProducto.add(jbtnRegistrarNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 240, 50));

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JButton jbtnCambiarContrasenia;
    public javax.swing.JButton jbtnCambiarEstado;
    public javax.swing.JButton jbtnCambiarImagen;
    public javax.swing.JButton jbtnCambiarPrecioCompra;
    public javax.swing.JButton jbtnCambiarPrecioVenta;
    public javax.swing.JButton jbtnCambiarStock;
    public javax.swing.JButton jbtnCerrarSesion;
    public javax.swing.JButton jbtnEliminarProducto;
    public javax.swing.JButton jbtnEmpleados;
    public javax.swing.JButton jbtnInicio;
    public javax.swing.JButton jbtnProducto;
    public javax.swing.JButton jbtnRegistrarNuevoEmpleado;
    public javax.swing.JButton jbtnRegistrarNuevoProducto;
    public javax.swing.JButton jbtnVentas;
    public javax.swing.JLabel jlblCantidad;
    public javax.swing.JLabel jlblCerrar;
    private javax.swing.JLabel jlblDniE;
    public javax.swing.JLabel jlblDniI;
    public javax.swing.JLabel jlblEmpleadoNombre;
    private javax.swing.JLabel jlblEstadoE;
    public javax.swing.JLabel jlblEstadoI;
    public javax.swing.JLabel jlblEstadoI1;
    private javax.swing.JLabel jlblIDE;
    public javax.swing.JLabel jlblIDI;
    private javax.swing.JLabel jlblIDProductoE;
    public javax.swing.JLabel jlblIDProductoI;
    private javax.swing.JLabel jlblInfEmpleado;
    private javax.swing.JLabel jlblInfEmpleado1;
    private javax.swing.JLabel jlblInfProducto;
    public javax.swing.JLabel jlblLogoTienda;
    public javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblNombreCE;
    public javax.swing.JLabel jlblNombreCI;
    private javax.swing.JLabel jlblNombreP;
    public javax.swing.JLabel jlblNombreProductoI;
    private javax.swing.JLabel jlblPassE;
    public javax.swing.JLabel jlblPrecioCompra;
    private javax.swing.JLabel jlblPrecioCompraE;
    public javax.swing.JLabel jlblPrecioVenta;
    private javax.swing.JLabel jlblPrecioVentaE;
    public javax.swing.JLabel jlblProductoImg;
    private javax.swing.JLabel jlblProductoImgE;
    private javax.swing.JLabel jlblRolE;
    public javax.swing.JLabel jlblRolI;
    private javax.swing.JLabel jlblStockE;
    private javax.swing.JLabel jlblTelefonoE;
    public javax.swing.JLabel jlblTelefonoI;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblTituloEmpleado;
    private javax.swing.JLabel jlblTituloEmpleado1;
    private javax.swing.JLabel jlblTituloProducto;
    private javax.swing.JLabel jlblUsernameE;
    public javax.swing.JLabel jlblUsernameI;
    private javax.swing.JPanel jpnlBarraOpciones;
    private javax.swing.JPanel jpnlBarraTitulo;
    private javax.swing.JPanel jpnlEmpleado;
    private javax.swing.JPanel jpnlInicio;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlProducto;
    private javax.swing.JPanel jpnlVentas;
    public javax.swing.JTable jtblEmpleados;
    public javax.swing.JTable jtblProductos;
    public javax.swing.JTable jtblVentas;
    public javax.swing.JTabbedPane jtpnlVentanas;
    // End of variables declaration//GEN-END:variables

}
