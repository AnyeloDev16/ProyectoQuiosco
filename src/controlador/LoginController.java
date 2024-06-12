package controlador;

import modelo.service.OperationResult;
import modelo.service.ServiceLogin;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.entidad.*;
import vista.AdministradorVista;
import vista.CajeroVista;
import vista.Login;

public class LoginController implements MouseListener{
    
    private final Login vistaLogin;

    public LoginController(Login vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.jlblCerrar.addMouseListener(this);
        this.vistaLogin.jlblMinimizar.addMouseListener(this);
        this.vistaLogin.jbtnIngresar.addMouseListener(this);
    }
 
    public void iniciar(){
        this.vistaLogin.setVisible(true);
        this.vistaLogin.setLocationRelativeTo(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vistaLogin.jlblCerrar){
            this.vistaLogin.dispose();
        }
        if(e.getSource() == this.vistaLogin.jlblMinimizar){
            this.vistaLogin.setState(JFrame.ICONIFIED);
        }
        if(e.getSource() == this.vistaLogin.jbtnIngresar){
            
            String user = this.vistaLogin.jtxtUsername.getText();
            String pass = String.valueOf(this.vistaLogin.jpswPassword.getPassword());
            
            Credencial crd = new Credencial(user, pass);   
            
            JOptionPane.showMessageDialog(null, crd.getPassword());
            
            ServiceLogin servicio = ServiceLogin.getInstance();
            
            OperationResult or = servicio.accederSistema(crd);
            
            accionIngresar(or);
            
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == this.vistaLogin.jlblCerrar){
            this.vistaLogin.jlblCerrar.setBackground(new Color(215, 0, 0));
        }
        if(e.getSource() == this.vistaLogin.jlblMinimizar){
            this.vistaLogin.jlblMinimizar.setBackground(new Color(220, 220, 220));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this.vistaLogin.jlblCerrar){
            this.vistaLogin.jlblCerrar.setBackground(Color.red);
        }
        if(e.getSource() == this.vistaLogin.jlblMinimizar){
            this.vistaLogin.jlblMinimizar.setBackground(new Color(239, 239, 239));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.vistaLogin.jlblCerrar){
            this.vistaLogin.jlblCerrar.setBackground(Color.WHITE);
        }
        if(e.getSource() == this.vistaLogin.jlblMinimizar){
            this.vistaLogin.jlblMinimizar.setBackground(Color.WHITE);
        }
    }

    private void accionIngresar(OperationResult or) {
    
        switch(or.getEstadoOperation()){
                case -1 -> JOptionPane.showMessageDialog(null,or.getMensaje());
                case 0 -> JOptionPane.showMessageDialog(null,or.getMensaje());
                case 1 -> {
                
                    Empleado emp = (Empleado)or.getObjeto().get("Empleado");
                    Rol rol = (Rol)or.getObjeto().get("Rol");
                
                    if(rol.getIdRol() == 1){
                        
                        AdministradorVista vistaAdm = new AdministradorVista();
                        
                        AdmMenuController ctrlAdm = new AdmMenuController(vistaAdm, emp);
                        
                        ctrlAdm.iniciar();
                        this.vistaLogin.dispose();
                        
                    } else if(rol.getIdRol() == 2){
                        
                        CajeroVista vistaAdm = new CajeroVista();
                        
                        CajeroController ctrlCaj = new CajeroController();
                        
//                        ctrlCaj.iniciar();
                        this.vistaLogin.dispose();
                        
                    }
                    
                }
            }
        
    }

}
