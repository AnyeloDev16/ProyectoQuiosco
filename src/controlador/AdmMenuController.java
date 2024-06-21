package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.entidad.Employee;
import vista.AdministradorVista;
import vista.Login;

/**
 * Controlador para la vista del menú del administrador.
 * Maneja eventos de mouse para los botones y gestiona las interacciones de usuario.
 */
public class AdmMenuController implements MouseListener{
    
    AdministradorVista vistaAdm;
    Employee modelo;

    private JButton botonAnterior;

    boolean isOpenVentaInicio = false;
    boolean isOpenVentaVenta = false;
    boolean isOpenVentaEmpleado = false;
    boolean isOpenVentaProducto = false;
    
    /**
     * Inicia la interfaz de usuario del administrador cargando los datos personales del empleado.
     */
    public AdmMenuController(AdministradorVista vistaAdm, Employee modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.vistaAdm.jlblCerrar.addMouseListener(this);
        this.vistaAdm.jlblMinimizar.addMouseListener(this);
        this.vistaAdm.jbtnInicio.addMouseListener(this);
        this.vistaAdm.jbtnVentas.addMouseListener(this);
        this.vistaAdm.jbtnEmpleados.addMouseListener(this);
        this.vistaAdm.jbtnProducto.addMouseListener(this);
        this.vistaAdm.jbtnCerrarSesion.addMouseListener(this);
    }
    
    public void iniciar(){
        cargarDatosPersonales();
        this.vistaAdm.mostrarVentana();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getSource() == this.vistaAdm.jlblCerrar){
            
            this.vistaAdm.cerrarVentana();
            
        } else if(e.getSource() == this.vistaAdm.jlblMinimizar){
            
            this.vistaAdm.minimizarVentana();
            
        } else if(e.getSource() == this.vistaAdm.jbtnInicio){

            cambiarColor(vistaAdm.jbtnInicio);
    
            // posible controlador pero no hay nada por el momento         
            this.vistaAdm.jtpnlVentanas.setSelectedIndex(0);
                     
        } else if(e.getSource() == this.vistaAdm.jbtnVentas){
            
            cambiarColor(vistaAdm.jbtnVentas);
            // TODO: Controlador ventas          
            this.vistaAdm.jtpnlVentanas.setSelectedIndex(1);
                     
        } else if(e.getSource() == this.vistaAdm.jbtnEmpleados){
            
            cambiarColor(vistaAdm.jbtnEmpleados);     
            if(!isOpenVentaEmpleado){
                AdmEmpleadoController empCtrl = new AdmEmpleadoController(vistaAdm, modelo);
                isOpenVentaEmpleado = true;
            } 
            this.vistaAdm.jtpnlVentanas.setSelectedIndex(2);
                     
        } else if(e.getSource() == this.vistaAdm.jbtnProducto){
            
            cambiarColor(vistaAdm.jbtnProducto);
            if(!isOpenVentaProducto){
                AdmProductoController proCtrl = new AdmProductoController(vistaAdm, modelo);
                isOpenVentaProducto = true;
            }          
            this.vistaAdm.jtpnlVentanas.setSelectedIndex(3);
                     
        } else if(e.getSource() == this.vistaAdm.jbtnCerrarSesion){
            
            this.vistaAdm.jbtnCerrarSesion.setBackground(new Color(215, 0, 0));
            this.vistaAdm.jbtnCerrarSesion.setForeground(new Color(255, 255, 255));              
            
            int response = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar sesión?", "Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(response == JOptionPane.YES_OPTION){
                
                vistaAdm.cerrarVentana();
                Login vista = new Login();
                LoginController ctrlLogin = new LoginController(vista);
                
                ctrlLogin.iniciar();
                
            } else if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION){
                
                this.vistaAdm.jbtnCerrarSesion.setBackground(new Color(255, 255, 255));
                this.vistaAdm.jbtnCerrarSesion.setForeground(new Color(102, 102, 102));  
                
            }

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

    /**
     * Cambia el color del botón clicado y restaura el estado de los botones previamente seleccionados.
     *
     * @param botonClikeado Botón que ha sido clicado por el usuario.
     */
    private void cambiarColor(JButton botonClikeado) {
    
            botonClikeado.setBackground(new Color(29, 53, 87));
            botonClikeado.setForeground(new Color(255,255,255));

            if(botonAnterior!= null && botonAnterior != botonClikeado){
                botonAnterior.setBackground(new Color(255, 255, 255));
                botonAnterior.setForeground(new Color(102, 102, 102));
            }
    
            botonAnterior = botonClikeado;
            
    }
    
}
