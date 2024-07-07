package main;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;

import controlador.LoginController;
import modelo.dao.OperationResult;
import modelo.entidad.Credential;
import modelo.entidad.Employee;
import modelo.service.AdminService;
import vista.Login;

public class main {

    public static void main(String[] args) {
        
        FlatArcDarkIJTheme.setup();
        
        Login mv = new Login();
        
        LoginController loginctrl = new LoginController(mv);
        
        loginctrl.iniciar();

//          AdminService as = AdminService.getInstance();
//          
//          Employee emp = Employee.builder()
//                  .nombre("Anyelo")
//                  .apellidoP("Nuñez")
//                  .apellidoM("Obispo")
//                  .dni("74910776")
//                  .estado(true)
//                  .telefono("986338188")
//                  .build();
//          
//          Credential cred = new Credential("nuanyeloob", "anyelo7491");
//          
//          cred.setPassword(Credential.hashPassword(cred.getPassword()));
//          
//          OperationResult or = as.agregarEmpleadoConRolYCredencias(emp, cred, 1);
//          
//          System.out.println(or.getMessage());
        
    }

}
