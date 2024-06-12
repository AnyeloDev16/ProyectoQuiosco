package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.entidad.Credencial;
import modelo.entidad.Empleado;
import modelo.service.ServiceAdministrador;
import modelo.service.StoredProcedureResult;
import vista.RegistrarEmpleadoFrm;

public class AdmRegEmpleadoController implements MouseListener {

    RegistrarEmpleadoFrm vistaRegistrar;

    public AdmRegEmpleadoController(RegistrarEmpleadoFrm vistaRegistrar) {
        this.vistaRegistrar = vistaRegistrar;
        this.vistaRegistrar.jbtnRegistrarEmpleado.addMouseListener(this);
    }

    public void iniciarRegistroEmpleado(RegistrarEmpleadoFrm vistaRegistrar) {

        vistaRegistrar.setLocationRelativeTo(null);
        vistaRegistrar.setVisible(true);

    }

    private Credencial crearCredencial(String nom, String apeP, String apeM, String dni) {

        // username
        Random rand = new Random();
        int numAleuser = rand.nextInt(5) + 1;

        String username = switch (numAleuser) {

            case 1 ->
                (String.valueOf(nom.charAt(0)) + ((apeP.length() >= 9) ? apeP.substring(0, 8) : apeP) + apeM.substring(0, 3)).toLowerCase();
            case 2 ->
                (nom.substring(0, 3) + apeP.substring(0, 3) + ((apeM.length() >= 7) ? apeP.substring(0, 6) : apeM)).toLowerCase();
            case 3 ->
                (apeP.substring(0, 2) + ((nom.length() >= 9) ? nom.substring(0, 8) : nom) + apeM.substring(0, 2)).toLowerCase();
            case 4 ->
                (apeP.substring(0, 3) + apeM.substring(0, 3) + ((nom.length() >= 7) ? nom.substring(0, 6) : nom)).toLowerCase();
            case 5 ->
                (apeM.substring(0, 3) + ((nom.length() >= 7) ? nom.substring(0, 6) : nom) + apeP.substring(0, 3)).toLowerCase();
            default ->
                "";
        };

        // password
        int numAlepass = rand.nextInt(3) + 1;

        String password = switch (numAlepass) {

            case 1 ->
                (nom + dni.substring(0, 4)).toLowerCase();
            case 2 ->
                (dni.substring(0, 2) + apeP + dni.substring(6, 8)).toLowerCase();
            case 3 ->
                (dni.substring(4, 8) + nom.charAt(0) + apeM.substring(0, 2)).toLowerCase();
            case 4 ->
                (apeP + dni.substring(2, 4) + nom.charAt(nom.length() - 1)).toLowerCase();
            case 5 ->
                (nom.substring(0, 2) + dni.substring(0, 2) + apeM.charAt(apeM.length() - 1)).toLowerCase();
            default ->
                "";
        };

        JOptionPane.showMessageDialog(null, password);
        
        return new Credencial(username, password);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == this.vistaRegistrar.jbtnRegistrarEmpleado) {

            String nombre = vistaRegistrar.jtxtNombre.getText();
            String apellidoP = vistaRegistrar.jtxtApellidoPaterno.getText();
            String apellidoM = vistaRegistrar.jtxtApellidoMaterno.getText();
            String dni = vistaRegistrar.jtxtDNI.getText();
            String telefono = vistaRegistrar.jtxtTelefono.getText();

            Empleado emp = new Empleado(nombre, apellidoP, apellidoM, telefono, dni);

            Credencial cred = crearCredencial(nombre, apellidoP, apellidoM, dni);   
            
            JOptionPane.showMessageDialog(null, cred.getPassword());
            
            cred.setPassword(Credencial.hashearContrasenia(cred.getPassword()));
            
            int rol = vistaRegistrar.jcbxRol.getSelectedIndex() + 1;

            ServiceAdministrador sa = ServiceAdministrador.getInstance();

            StoredProcedureResult spr = sa.agregarEmpleadoConRolYCredencias(emp, cred, rol);

            JOptionPane.showMessageDialog(null, spr.getMensaje());

            if (spr.getEstadoInsert() == 1) {
                this.vistaRegistrar.dispose();
            }

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
