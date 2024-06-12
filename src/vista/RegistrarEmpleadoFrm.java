package vista;

import vista.tipografia.Tipografia;

public class RegistrarEmpleadoFrm extends javax.swing.JDialog {

    Tipografia fuente;
    
    public RegistrarEmpleadoFrm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTipografia();
    }

    private void setTipografia() {
    
        fuente = new Tipografia();
        
        this.jlblTitulo.setFont(fuente.fuente(fuente.ROBOTO, 1, 22));
        
        this.jlblNombre.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblApellidoPaterno.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblApellidoMaterno.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblDNI.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblTelefono.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        this.jlblRol.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        
        this.jtxtNombre.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        this.jtxtApellidoPaterno.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        this.jtxtApellidoMaterno.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        this.jtxtDNI.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        this.jtxtTelefono.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        this.jcbxRol.setFont(fuente.fuente(fuente.ROBOTO, 0, 16));
        
        this.jbtnRegistrarEmpleado.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPrincipal = new javax.swing.JPanel();
        jpnlTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jpnlRegistro = new javax.swing.JPanel();
        jbtnRegistrarEmpleado = new javax.swing.JButton();
        jlblNombre = new javax.swing.JLabel();
        jtxtTelefono = new javax.swing.JTextField();
        jlblApellidoPaterno = new javax.swing.JLabel();
        jlblApellidoMaterno = new javax.swing.JLabel();
        jlblDNI = new javax.swing.JLabel();
        jlblTelefono = new javax.swing.JLabel();
        jlblRol = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellidoPaterno = new javax.swing.JTextField();
        jtxtApellidoMaterno = new javax.swing.JTextField();
        jtxtDNI = new javax.swing.JTextField();
        jcbxRol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jpnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlTitulo.setBackground(new java.awt.Color(44, 62, 80));
        jpnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jlblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitulo.setText("REGISTRO DE EMPLEADO NUEVO");
        jpnlTitulo.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 388, 38));

        jpnlPrincipal.add(jpnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        jpnlRegistro.setBackground(new java.awt.Color(52, 73, 94));
        jpnlRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnRegistrarEmpleado.setBackground(new java.awt.Color(39, 174, 96));
        jbtnRegistrarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistrarEmpleado.setText("Registrar Empleado");
        jpnlRegistro.add(jbtnRegistrarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 280, 52));

        jlblNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblNombre.setText("Primer Nombre:");
        jpnlRegistro.add(jlblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));

        jtxtTelefono.setBackground(new java.awt.Color(236, 240, 241));
        jtxtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 195, 190, 30));

        jlblApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblApellidoPaterno.setText("Apellido Paterno:");
        jpnlRegistro.add(jlblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jlblApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblApellidoMaterno.setText("Apellido Materno:");
        jpnlRegistro.add(jlblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jlblDNI.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblDNI.setText("DNI:");
        jpnlRegistro.add(jlblDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jlblTelefono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblTelefono.setText("Teléfono:");
        jpnlRegistro.add(jlblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jlblRol.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlblRol.setText("Rol del Empledo");
        jpnlRegistro.add(jlblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jtxtNombre.setBackground(new java.awt.Color(236, 240, 241));
        jtxtNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 35, 190, 30));

        jtxtApellidoPaterno.setBackground(new java.awt.Color(236, 240, 241));
        jtxtApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtApellidoPaterno.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 75, 190, 30));

        jtxtApellidoMaterno.setBackground(new java.awt.Color(236, 240, 241));
        jtxtApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtApellidoMaterno.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 115, 190, 30));

        jtxtDNI.setBackground(new java.awt.Color(236, 240, 241));
        jtxtDNI.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtDNI.setForeground(new java.awt.Color(0, 0, 0));
        jpnlRegistro.add(jtxtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 155, 190, 30));

        jcbxRol.setBackground(new java.awt.Color(236, 240, 241));
        jcbxRol.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jcbxRol.setForeground(new java.awt.Color(0, 0, 0));
        jcbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Cajero" }));
        jpnlRegistro.add(jcbxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 235, 190, 30));

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
    public javax.swing.JButton jbtnRegistrarEmpleado;
    public javax.swing.JComboBox<String> jcbxRol;
    private javax.swing.JLabel jlblApellidoMaterno;
    private javax.swing.JLabel jlblApellidoPaterno;
    private javax.swing.JLabel jlblDNI;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblRol;
    private javax.swing.JLabel jlblTelefono;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlRegistro;
    private javax.swing.JPanel jpnlTitulo;
    public javax.swing.JTextField jtxtApellidoMaterno;
    public javax.swing.JTextField jtxtApellidoPaterno;
    public javax.swing.JTextField jtxtDNI;
    public javax.swing.JTextField jtxtNombre;
    public javax.swing.JTextField jtxtTelefono;
    // End of variables declaration//GEN-END:variables

}
