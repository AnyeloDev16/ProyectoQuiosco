package vista;

import java.awt.geom.RoundRectangle2D;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),15,15));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpblVentanaCompleta = new javax.swing.JPanel();
        jpnlPrincipal = new javax.swing.JPanel();
        jlblMinimizar = new javax.swing.JLabel();
        jlblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);

        jpblVentanaCompleta.setMaximumSize(new java.awt.Dimension(800, 500));
        jpblVentanaCompleta.setPreferredSize(new java.awt.Dimension(800, 500));
        jpblVentanaCompleta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpnlPrincipal.setMaximumSize(new java.awt.Dimension(800, 500));
        jpnlPrincipal.setMinimumSize(new java.awt.Dimension(800, 500));
        jpnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        jlblMinimizar.setForeground(new java.awt.Color(51, 51, 51));
        jlblMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMinimizar.setText("-");
        jlblMinimizar.setOpaque(true);
        jpnlPrincipal.add(jlblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 50, 30));

        jlblCerrar.setBackground(new java.awt.Color(255, 255, 255));
        jlblCerrar.setForeground(new java.awt.Color(51, 51, 51));
        jlblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblCerrar.setText("X");
        jlblCerrar.setOpaque(true);
        jpnlPrincipal.add(jlblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 50, 30));

        jpblVentanaCompleta.add(jpnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 500, 500));

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
    public javax.swing.JLabel jlblCerrar;
    public javax.swing.JLabel jlblMinimizar;
    private javax.swing.JPanel jpblVentanaCompleta;
    private javax.swing.JPanel jpnlPrincipal;
    // End of variables declaration//GEN-END:variables
}


