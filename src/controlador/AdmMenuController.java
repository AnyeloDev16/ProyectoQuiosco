package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.entidad.Employee;
import vista.AdministradorVista;

public class AdmMenuController implements MouseListener{
    
    AdministradorVista vistaAdm;
    Employee modelo;

    public AdmMenuController(AdministradorVista vistaAdm, Employee modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.vistaAdm.jlblCerrar.addMouseListener(this);
        this.vistaAdm.jlblMinimizar.addMouseListener(this);
        this.vistaAdm.jbtnEmpleados.addMouseListener(this);
    }
    
    public void iniciar(){
        cargarDatosPersonales();
        this.vistaAdm.mostrarVentana();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getSource() == this.vistaAdm.jlblCerrar){
            this.vistaAdm.cerrarVentana();
        }
        if(e.getSource() == this.vistaAdm.jlblMinimizar){
            this.vistaAdm.minimizarVentana();
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
 
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }   
    
    @Override
    public void mouseReleased(MouseEvent e) {    
        
    }

    private void cargarDatosPersonales() {
        
        String nombreCompleto = modelo.getNombre()+" "+modelo.getApellidoP();       
        this.vistaAdm.jlblEmpleadoNombre.setText(nombreCompleto);
        
    }
    
}
