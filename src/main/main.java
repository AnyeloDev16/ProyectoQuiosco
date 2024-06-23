package main;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;

import controlador.LoginController;
import vista.Login;

public class main {

    public static void main(String[] args) {
        
        FlatArcDarkIJTheme.setup();
        
        Login mv = new Login();
        
        LoginController loginctrl = new LoginController(mv);
        
        loginctrl.iniciar();
        
    }

}
