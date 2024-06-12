package vista;

import java.awt.geom.RoundRectangle2D;
import vista.tipografia.Tipografia;

public class Login extends javax.swing.JFrame {

    Tipografia fuente;
    
    public Login() {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),30,30));
        this.setTipografia();      
    }
    
    private void setTipografia(){
        fuente = new Tipografia();
        jlblTitulo.setFont(fuente.fuente(fuente.ROBOTO, 1, 36));
        jlblTextIngresa.setFont(fuente.fuente(fuente.ROBOTO, 1, 18));
        jlblTextUsuario.setFont(fuente.fuente(fuente.ROBOTO, 0, 14));
        jlbltextContrasenia.setFont(fuente.fuente(fuente.ROBOTO, 0, 14));
        jtxtUsername.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jpswPassword.setFont(fuente.fuente(fuente.ROBOTO, 1, 16));
        jbtnIngresar.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jlblTextOlvido.setFont(fuente.fuente(fuente.ROBOTO, 0, 14));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpblVentanaCompleta = new javax.swing.JPanel();
        jpnlPrincipal = new javax.swing.JPanel();
        jlblMinimizar = new javax.swing.JLabel();
        jlblCerrar = new javax.swing.JLabel();
        jlblTitulo = new javax.swing.JLabel();
        jtxtUsername = new javax.swing.JTextField();
        jpswPassword = new javax.swing.JPasswordField();
        jbtnIngresar = new javax.swing.JButton();
        jlblTextUsuario = new javax.swing.JLabel();
        jlbltextContrasenia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jlblTextIngresa = new javax.swing.JLabel();
        jlblTextOlvido = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);

        jpblVentanaCompleta.setMaximumSize(new java.awt.Dimension(800, 500));
        jpblVentanaCompleta.setPreferredSize(new java.awt.Dimension(800, 500));
        jpblVentanaCompleta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpnlPrincipal.setMaximumSize(new java.awt.Dimension(500, 500));
        jpnlPrincipal.setMinimumSize(new java.awt.Dimension(500, 500));
        jpnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        jlblMinimizar.setForeground(new java.awt.Color(51, 51, 51));
        jlblMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMinimizar.setText("-");
        jlblMinimizar.setOpaque(true);
        jpnlPrincipal.add(jlblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 50, 30));

        jlblCerrar.setBackground(new java.awt.Color(255, 255, 255));
        jlblCerrar.setForeground(new java.awt.Color(51, 51, 51));
        jlblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblCerrar.setText("X");
        jlblCerrar.setOpaque(true);
        jpnlPrincipal.add(jlblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 50, 30));

        jlblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jlblTitulo.setForeground(new java.awt.Color(102, 102, 102));
        jlblTitulo.setText("Bienvenido al Quiosco!");
        jpnlPrincipal.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 40));

        jtxtUsername.setBackground(new java.awt.Color(255, 255, 255));
        jtxtUsername.setForeground(new java.awt.Color(102, 102, 102));
        jtxtUsername.setBorder(null);
        jpnlPrincipal.add(jtxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 270, 30));

        jpswPassword.setBackground(new java.awt.Color(255, 255, 255));
        jpswPassword.setForeground(new java.awt.Color(102, 102, 102));
        jpswPassword.setBorder(null);
        jpnlPrincipal.add(jpswPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 270, 30));

        jbtnIngresar.setBackground(new java.awt.Color(0, 123, 255));
        jbtnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnIngresar.setText("INGRESAR");
        jpnlPrincipal.add(jbtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 190, 40));

        jlblTextUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlblTextUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jlblTextUsuario.setText("Usuario:");
        jpnlPrincipal.add(jlblTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jlbltextContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbltextContrasenia.setForeground(new java.awt.Color(102, 102, 102));
        jlbltextContrasenia.setText("Contraseña:");
        jpnlPrincipal.add(jlbltextContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/user.png"))); // NOI18N
        jpnlPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 40, 30));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jpnlPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 320, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/password.png"))); // NOI18N
        jpnlPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 40, 30));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jpnlPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 320, 20));

        jlblTextIngresa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlblTextIngresa.setText("Ingresa a tu cuenta");
        jpnlPrincipal.add(jlblTextIngresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jlblTextOlvido.setForeground(new java.awt.Color(51, 51, 51));
        jlblTextOlvido.setText("¿Olvidaste tu contraseña?");
        jpnlPrincipal.add(jlblTextOlvido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        jpblVentanaCompleta.add(jpnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 450, 500));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/LoginPortada.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpblVentanaCompleta.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpblVentanaCompleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpblVentanaCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JButton jbtnIngresar;
    public javax.swing.JLabel jlblCerrar;
    public javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblTextIngresa;
    private javax.swing.JLabel jlblTextOlvido;
    private javax.swing.JLabel jlblTextUsuario;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlbltextContrasenia;
    private javax.swing.JPanel jpblVentanaCompleta;
    private javax.swing.JPanel jpnlPrincipal;
    public javax.swing.JPasswordField jpswPassword;
    public javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}


