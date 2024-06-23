package vista;

import vista.tipografia.Tipografia;

public class ProductoComponent extends javax.swing.JPanel {

    Tipografia fuente;
    
    public ProductoComponent() {
        initComponents();
        setTipografia();
    }

    private void setTipografia(){
        fuente = new Tipografia();
        jlblNombreI.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
        jlblPrecioI.setFont(fuente.fuente(fuente.ROBOTO, 1, 12));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblProductoImg = new javax.swing.JLabel();
        jlblPrecioI = new javax.swing.JLabel();
        jlblNombreI = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(160, 170));
        setMinimumSize(new java.awt.Dimension(160, 170));
        setPreferredSize(new java.awt.Dimension(160, 170));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jlblProductoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 100));

        jlblPrecioI.setForeground(new java.awt.Color(0, 0, 0));
        jlblPrecioI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jlblPrecioI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 16));

        jlblNombreI.setForeground(new java.awt.Color(0, 0, 0));
        jlblNombreI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jlblNombreI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 16));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jlblNombreI;
    public javax.swing.JLabel jlblPrecioI;
    public javax.swing.JLabel jlblProductoImg;
    // End of variables declaration//GEN-END:variables
}
