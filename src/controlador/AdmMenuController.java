package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import modelo.entidad.Empleado;
import vista.AdministradorVista;

public class AdmMenuController implements MouseListener{
    
    AdministradorVista vistaAdm;
    Empleado modelo;

    public AdmMenuController(AdministradorVista vistaAdm, Empleado modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.vistaAdm.jlblCerrar.addMouseListener(this);
        this.vistaAdm.jlblMinimizar.addMouseListener(this);
        this.vistaAdm.jbtnEmpleados.addMouseListener(this);
    }
    
    public void iniciar(){
        cargarDatosPersonales();
        this.vistaAdm.setVisible(true);
        this.vistaAdm.setLocationRelativeTo(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getSource() == this.vistaAdm.jlblCerrar){
            this.vistaAdm.dispose();
        }
        if(e.getSource() == this.vistaAdm.jlblMinimizar){
            this.vistaAdm.setState(JFrame.ICONIFIED);
        }
        
        if(e.getSource() == this.vistaAdm.jbtnEmpleados){
            
            this.vistaAdm.jbtnEmpleados.setBackground(new Color(29, 53, 87));
            this.vistaAdm.jbtnEmpleados.setForeground(new Color(255,255,255));     
            AdmEmpleadoController empCtrl = new AdmEmpleadoController(vistaAdm, modelo);          
            this.vistaAdm.jtpnlVentanas.setSelectedIndex(2);
                     
        }
              
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
        if(e.getSource() == this.vistaAdm.jlblCerrar){
            this.vistaAdm.jlblCerrar.setBackground(new Color(215, 0, 0));
        }
        if(e.getSource() == this.vistaAdm.jlblMinimizar){
            this.vistaAdm.jlblMinimizar.setBackground(new Color(38, 75, 130));
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
        if(e.getSource() == this.vistaAdm.jlblCerrar){
            this.vistaAdm.jlblCerrar.setBackground(Color.red);
        }
        if(e.getSource() == this.vistaAdm.jlblMinimizar){
            this.vistaAdm.jlblMinimizar.setBackground(new Color(41, 87, 164));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
    
        if(e.getSource() == this.vistaAdm.jlblCerrar){
            this.vistaAdm.jlblCerrar.setBackground(new Color(45, 110, 208));
        }
        if(e.getSource() == this.vistaAdm.jlblMinimizar){
            this.vistaAdm.jlblMinimizar.setBackground(new Color(45, 110, 208));
        }
        
    }   
    
    @Override
    public void mouseReleased(MouseEvent e) {    
        
    }

    private void cargarDatosPersonales() {
        
        String nombreCompleto = modelo.getNombre()+" "+modelo.getApellidoP();       
        this.vistaAdm.jlblEmpleadoNombre.setText(nombreCompleto);
        
    }
    
}
