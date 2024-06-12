package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.entidad.Empleado;
import vista.AdministradorVista;
import vista.RegistrarEmpleadoFrm;

public class AdmEmpleadoController implements MouseListener{

    AdministradorVista vistaAdm;
    Empleado modelo;

    public AdmEmpleadoController(AdministradorVista vistaAdm, Empleado modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.vistaAdm.jbtnRegitrarNuevoEmpleado.addMouseListener(this);
    }
    
    public void iniciarRegistroEmpleado(RegistrarEmpleadoFrm vistaRegistrar){
        
        vistaRegistrar.setLocationRelativeTo(null);
        vistaRegistrar.setVisible(true);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getSource() == vistaAdm.jbtnRegitrarNuevoEmpleado){
            
            RegistrarEmpleadoFrm vistaRegistrar = new RegistrarEmpleadoFrm(vistaAdm,true);           
            iniciarRegistroEmpleado(vistaRegistrar);
            
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
