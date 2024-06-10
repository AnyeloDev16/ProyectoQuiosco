package controlador;

import modelo.entidad.Empleado;
import vista.AdministradorVista;

public class AdministradorController {
    
    AdministradorVista vistaAdm;
    Empleado modelo;

    public AdministradorController(AdministradorVista vistaAdm, Empleado modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
    }
    
    public void iniciar(){
        this.vistaAdm.setVisible(true);
        this.vistaAdm.setLocationRelativeTo(null);
    }
    
}
