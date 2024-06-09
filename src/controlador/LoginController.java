package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import org.mindrot.jbcrypt.BCrypt;
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
            
            System.out.println("pass = " + hashearContrasenia(pass));    
            
        }
    }

    public String hashearContrasenia(String password){
        
        int saltos = 12;
        
        return BCrypt.hashpw(password, BCrypt.gensalt(saltos));
        
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

}
