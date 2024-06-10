package main;

import Service.ServiceAdministrador;
import Service.StoredProcedureResult;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controlador.LoginController;
import modelo.entidad.*;
import vista.Login;

public class main {

    public static void main(String[] args) {
        
//        FlatMaterialLighterIJTheme.setup();
//        
//        Login mv = new Login();
//        
//        LoginController loginctrl = new LoginController(mv);
//        
//        loginctrl.iniciar();

        Empleado emp = new Empleado("Joel", "Dominguez", "Gutierrez", "986338188", "54557755");
        Credencial cred = new Credencial("1235","1235");
        
        StoredProcedureResult spr = ServiceAdministrador.getInstance().agregarEmpleadoConRolYCredencias(emp, cred, 1);
        
        System.out.println("mensaje: " + spr.getMensaje());
        
    }

}
