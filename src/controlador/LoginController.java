package controlador;

import modelo.dao.OperationResult;
import modelo.service.LoginService;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.entidad.*;
import vista.AdministradorVista;
import vista.CajeroVista;
import vista.Login;

public class LoginController implements MouseListener {

    private final Login vistaLogin;

    public LoginController(Login vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.jlblMinimizar.addMouseListener(this);
        this.vistaLogin.jlblCerrar.addMouseListener(this);
        this.vistaLogin.jbtnIngresar.addMouseListener(vistaLogin);
    }

    public void iniciar() {
        vistaLogin.mostrarVentana();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == this.vistaLogin.jlblCerrar) {
            vistaLogin.cerrarVentana();
        }
        if (e.getSource() == this.vistaLogin.jlblMinimizar) {
            vistaLogin.minimizarVentana();
        }
        if (e.getSource() == this.vistaLogin.jbtnIngresar) {

            String user = this.vistaLogin.jtxtUsername.getText();
            String pass = String.valueOf(this.vistaLogin.jpswPassword.getPassword());

            Credential crd = new Credential(user, pass);

            LoginService servicio = LoginService.getInstance();

            OperationResult or = servicio.accederSistema(crd);

            accionIngresar(or);

        }

    }

    private void accionIngresar(OperationResult or) {

        switch (or.getOperationStatus()) {
            case -2, -1, 0 ->
                this.vistaLogin.mostrarMensaje(or.getMessage());
            case 1 -> {

                Employee emp = (Employee) or.getData().get("Empleado");
                int rol_id = (Integer) or.getData().get("Rol");

                if (rol_id == 1) {

                    AdministradorVista vistaAdm = new AdministradorVista();

                    AdmMenuController ctrlAdm = new AdmMenuController(vistaAdm, emp);

                    ctrlAdm.iniciar();
                    this.vistaLogin.dispose();

                } else if (rol_id == 2) {

                    CajeroVista vistaAdm = new CajeroVista();

                    CajeroController ctrlCaj = new CajeroController();

//                    ctrlCaj.iniciar();
                    this.vistaLogin.dispose();

                }

            }
        }

    }

    // No hacen nada por el momento
    
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
