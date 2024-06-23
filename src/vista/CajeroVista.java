package vista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import vista.tipografia.Tipografia;

public class CajeroVista extends javax.swing.JFrame implements MouseListener{

    Tipografia fuente;
        
    public CajeroVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),30,30));
        this.jtblDetalleVenta.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.jtblDetalleVenta.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.jtblDetalleVenta.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.jtblDetalleVenta.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.jtblDetalleVenta.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.jtblDetalleVenta.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.setTipografia();
        this.jtblDetalleVenta.setDefaultEditor(Object.class, null);
        this.jtblDetalleVenta.setRowSelectionAllowed(true);
        this.jtblDetalleVenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jlblCerrar.addMouseListener(this);
        this.jlblMinimizar.addMouseListener(this);
    }

    private void setTipografia(){
        fuente = new Tipografia();
        jlblTitulo.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jlblEmpleadoNombre.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnInicio.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnRealizarVentas.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnVentas.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jbtnCerrarSesion.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        //Empleado
        jlblTituloEmpleado.setFont(fuente.fuente(fuente.ROBOTO, 1, 30));
        jtblDetalleVenta.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        jlblInfEmpleado.setFont(fuente.fuente(fuente.ROBOTO, 1, 24));

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
        if(e.getSource() == this.jlblCerrar){
            this.jlblCerrar.setBackground(new Color(215, 0, 0));
        }
        if(e.getSource() == this.jlblMinimizar){
            this.jlblMinimizar.setBackground(new Color(38, 75, 130));
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
        if(e.getSource() == this.jlblCerrar){
            this.jlblCerrar.setBackground(Color.red);
        }
        if(e.getSource() == this.jlblMinimizar){
            this.jlblMinimizar.setBackground(new Color(41, 87, 164));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
    
        if(e.getSource() == this.jlblCerrar){
            this.jlblCerrar.setBackground(new Color(45, 110, 208));
        }
        if(e.getSource() == this.jlblMinimizar){
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
        jbtnRealizarVentas = new javax.swing.JButton();
        jbtnVentas = new javax.swing.JButton();
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
        jpnlRealizarVenta = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetalleVenta = new javax.swing.JTable();
        jlblInfEmpleado = new javax.swing.JLabel();
        jlblTituloEmpleado = new javax.swing.JLabel();
        jbtnRegistrarNuevoEmpleado = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jpnlListaProductos = new javax.swing.JPanel();
        jbtnRegistrarNuevoEmpleado1 = new javax.swing.JButton();
        jbtnRegistrarNuevoEmpleado3 = new javax.swing.JButton();
        jlblInfEmpleado2 = new javax.swing.JLabel();
        jlblPrecioTotal = new javax.swing.JLabel();
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

        jbtnRealizarVentas.setBackground(new java.awt.Color(255, 255, 255));
        jbtnRealizarVentas.setForeground(new java.awt.Color(102, 102, 102));
        jbtnRealizarVentas.setText("Realizar Venta");
        jpnlBarraOpciones.add(jbtnRealizarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 50));

        jbtnVentas.setBackground(new java.awt.Color(255, 255, 255));
        jbtnVentas.setForeground(new java.awt.Color(102, 102, 102));
        jbtnVentas.setText("Ventas");
        jpnlBarraOpciones.add(jbtnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 50));
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

        jpnlRealizarVenta.setBackground(new java.awt.Color(255, 255, 255));
        jpnlRealizarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnlRealizarVenta.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 10, 550));

        jScrollPane1.setBorder(null);

        jtblDetalleVenta.setBackground(new java.awt.Color(220, 220, 220));
        jtblDetalleVenta.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jtblDetalleVenta.setForeground(new java.awt.Color(0, 0, 0));
        jtblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cantidad", "Precio"
            }
        ));
        jtblDetalleVenta.setFocusable(false);
        jtblDetalleVenta.setOpaque(false);
        jtblDetalleVenta.setRequestFocusEnabled(false);
        jtblDetalleVenta.getTableHeader().setResizingAllowed(false);
        jtblDetalleVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblDetalleVenta);

        jpnlRealizarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 130, 440, 280));

        jlblInfEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlblInfEmpleado.setForeground(new java.awt.Color(29, 53, 87));
        jlblInfEmpleado.setText("Total de la Venta:");
        jpnlRealizarVenta.add(jlblInfEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 210, 30));

        jlblTituloEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jlblTituloEmpleado.setForeground(new java.awt.Color(29, 53, 87));
        jlblTituloEmpleado.setText("Realizar venta:");
        jpnlRealizarVenta.add(jlblTituloEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 280, 40));

        jbtnRegistrarNuevoEmpleado.setBackground(new java.awt.Color(51, 153, 255));
        jbtnRegistrarNuevoEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnRegistrarNuevoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistrarNuevoEmpleado.setText("Eliminar");
        jpnlRealizarVenta.add(jbtnRegistrarNuevoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 560, 190, 50));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        jpnlListaProductos.setBackground(new java.awt.Color(255, 255, 255));
        jpnlListaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnlListaProductos.setLayout(new java.awt.GridBagLayout());
        jScrollPane2.setViewportView(jpnlListaProductos);

        jpnlRealizarVenta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, 520, 560));

        jbtnRegistrarNuevoEmpleado1.setBackground(new java.awt.Color(51, 153, 255));
        jbtnRegistrarNuevoEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnRegistrarNuevoEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistrarNuevoEmpleado1.setText("Realizar Venta");
        jpnlRealizarVenta.add(jbtnRegistrarNuevoEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 390, 50));

        jbtnRegistrarNuevoEmpleado3.setBackground(new java.awt.Color(51, 153, 255));
        jbtnRegistrarNuevoEmpleado3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnRegistrarNuevoEmpleado3.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistrarNuevoEmpleado3.setText("Eliminar Todo");
        jpnlRealizarVenta.add(jbtnRegistrarNuevoEmpleado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 560, 190, 50));

        jlblInfEmpleado2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlblInfEmpleado2.setForeground(new java.awt.Color(29, 53, 87));
        jlblInfEmpleado2.setText("Detalle de la Compra:");
        jpnlRealizarVenta.add(jlblInfEmpleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 440, 30));

        jlblPrecioTotal.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jlblPrecioTotal.setForeground(new java.awt.Color(0, 0, 0));
        jlblPrecioTotal.setText("0.00");
        jpnlRealizarVenta.add(jlblPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 440, -1, -1));

        jtpnlVentanas.addTab("Empleado", jpnlRealizarVenta);

        jpnlVentas.setBackground(new java.awt.Color(255, 255, 255));
        jpnlVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnlVentas.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 10, 550));

        jScrollPane3.setBorder(null);

        jtblVentas.setBackground(new java.awt.Color(220, 220, 220));
        jtblVentas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jtblVentas.setForeground(new java.awt.Color(0, 0, 0));
        jtblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Venta ID", "Fecha", "Metodo de Pago", "Total de Venta"
            }
        ));
        jtblVentas.setFocusable(false);
        jtblVentas.setOpaque(false);
        jtblVentas.setRequestFocusEnabled(false);
        jtblVentas.getTableHeader().setResizingAllowed(false);
        jtblVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtblVentas);

        jpnlVentas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 450, 530));

        jlblInfEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlblInfEmpleado1.setForeground(new java.awt.Color(29, 53, 87));
        jlblInfEmpleado1.setText("Información completa de la Venta:");
        jpnlVentas.add(jlblInfEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 440, 30));

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

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 440, 390));

        jpnlVentas.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 480, 430));

        jlblTituloEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jlblTituloEmpleado1.setForeground(new java.awt.Color(29, 53, 87));
        jlblTituloEmpleado1.setText("HISTORIAL DE VENTAS:");
        jpnlVentas.add(jlblTituloEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 430, 40));

        jtpnlVentanas.addTab("Ventas", jpnlVentas);

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

    private void jbtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JButton jbtnCerrarSesion;
    public javax.swing.JButton jbtnInicio;
    public javax.swing.JButton jbtnRealizarVentas;
    public javax.swing.JButton jbtnRegistrarNuevoEmpleado;
    public javax.swing.JButton jbtnRegistrarNuevoEmpleado1;
    public javax.swing.JButton jbtnRegistrarNuevoEmpleado3;
    public javax.swing.JButton jbtnVentas;
    public javax.swing.JLabel jlblCerrar;
    public javax.swing.JLabel jlblEmpleadoNombre;
    public javax.swing.JLabel jlblEstadoI1;
    private javax.swing.JLabel jlblInfEmpleado;
    private javax.swing.JLabel jlblInfEmpleado1;
    private javax.swing.JLabel jlblInfEmpleado2;
    public javax.swing.JLabel jlblLogoTienda;
    public javax.swing.JLabel jlblMinimizar;
    public javax.swing.JLabel jlblPrecioTotal;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblTituloEmpleado;
    private javax.swing.JLabel jlblTituloEmpleado1;
    private javax.swing.JPanel jpnlBarraOpciones;
    private javax.swing.JPanel jpnlBarraTitulo;
    private javax.swing.JPanel jpnlInicio;
    public javax.swing.JPanel jpnlListaProductos;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlRealizarVenta;
    private javax.swing.JPanel jpnlVentas;
    public javax.swing.JTable jtblDetalleVenta;
    public javax.swing.JTable jtblVentas;
    public javax.swing.JTabbedPane jtpnlVentanas;
    // End of variables declaration//GEN-END:variables

    
}
