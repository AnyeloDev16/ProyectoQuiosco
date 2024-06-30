package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.entidad.Employee;
import vista.CajeroVista;
import vista.Login;

public class CajeroMenuController implements MouseListener{
    
    CajeroVista vistaCaj;
    Employee modelo;

    private JButton botonAnterior;

    boolean isOpenVentanaInicio = false;
    boolean isOpenVentanaRealizarventa = false;
    boolean isOpenVentanaVentas = false;
    
    public CajeroMenuController(CajeroVista vistaCaj, Employee modelo) {
        this.vistaCaj = vistaCaj;
        this.modelo = modelo;
        this.vistaCaj.jlblCerrar.addMouseListener(this);
        this.vistaCaj.jlblMinimizar.addMouseListener(this);
        this.vistaCaj.jbtnInicio.addMouseListener(this);
        this.vistaCaj.jbtnRealizarVentas.addMouseListener(this);
        this.vistaCaj.jbtnVentas.addMouseListener(this);
        this.vistaCaj.jbtnCerrarSesion.addMouseListener(this);
    }
    
    public void iniciar(){
        cargarDatosPersonales();
        this.vistaCaj.mostrarVentana();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getSource() == this.vistaCaj.jlblCerrar){
            
            this.vistaCaj.cerrarVentana();
            
        } else if(e.getSource() == this.vistaCaj.jlblMinimizar){
            
            this.vistaCaj.minimizarVentana();
            
        } else if(e.getSource() == this.vistaCaj.jbtnInicio){

            cambiarColor(vistaCaj.jbtnInicio);
    
            // posible controlador pero no hay nada por el momento         
            this.vistaCaj.jtpnlVentanas.setSelectedIndex(0);
                     
        } else if(e.getSource() == this.vistaCaj.jbtnRealizarVentas){
            
            cambiarColor(vistaCaj.jbtnRealizarVentas);     
            if(!isOpenVentanaRealizarventa){
                CajeroRealizarVentaController cajCtrl = new CajeroRealizarVentaController(vistaCaj, modelo);
                isOpenVentanaRealizarventa = true;
            } 
            this.vistaCaj.jtpnlVentanas.setSelectedIndex(1);
                     
        } else if(e.getSource() == this.vistaCaj.jbtnVentas){
            
            cambiarColor(vistaCaj.jbtnVentas);
            if(!isOpenVentanaVentas){
                CajeroVentaController cajCtrol = new CajeroVentaController(vistaCaj, modelo);
                isOpenVentanaVentas = true;
            }      
            this.vistaCaj.jtpnlVentanas.setSelectedIndex(2);           
            
        }  else if(e.getSource() == this.vistaCaj.jbtnCerrarSesion){
            
            this.vistaCaj.jbtnCerrarSesion.setBackground(new Color(215, 0, 0));
            this.vistaCaj.jbtnCerrarSesion.setForeground(new Color(255, 255, 255));              
            
            int response = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar sesión?", "Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(response == JOptionPane.YES_OPTION){
                
                vistaCaj.cerrarVentana();
                Login vista = new Login();
                LoginController ctrlLogin = new LoginController(vista);
                
                ctrlLogin.iniciar();
                
            } else if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION){
                
                this.vistaCaj.jbtnCerrarSesion.setBackground(new Color(255, 255, 255));
                this.vistaCaj.jbtnCerrarSesion.setForeground(new Color(102, 102, 102));  
                
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
        this.vistaCaj.jlblEmpleadoNombre.setText(nombreCompleto);
        
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
