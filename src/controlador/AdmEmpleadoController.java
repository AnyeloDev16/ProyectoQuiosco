package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.dao.*;
import modelo.entidad.Employee;
import vista.AdministradorVista;
import vista.RegistrarEmpleadoFrm;

public final class AdmEmpleadoController implements MouseListener, ListSelectionListener {

    AdministradorVista vistaAdm;
    Employee modelo;

    EmployeeDAO empDAO;
    CredentialDAO creDAO;

    ArrayList<Employee> listaEmp;

    public AdmEmpleadoController(AdministradorVista vistaAdm, Employee modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.empDAO = new EmployeeDAO();
        this.creDAO = new CredentialDAO();
        cargarEmpleados();
        this.vistaAdm.jbtnRegitrarNuevoEmpleado.addMouseListener(this);
        this.vistaAdm.jbtnCambiarEstado.addMouseListener(this);
        this.vistaAdm.jbtnCambiarContrasenia.addMouseListener(this);
        this.vistaAdm.jtblEmpleados.getSelectionModel().addListSelectionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vistaAdm.jbtnRegitrarNuevoEmpleado) {

            RegistrarEmpleadoFrm vistaRegistrar = new RegistrarEmpleadoFrm(vistaAdm, true);
            AdmRegEmpleadoController ctrlRegEmp = new AdmRegEmpleadoController(vistaRegistrar);
            ctrlRegEmp.iniciarRegistroEmpleado(vistaRegistrar);
            
            cargarEmpleados();

        } else if (e.getSource() == vistaAdm.jbtnCambiarEstado) {

            int id_emp = Integer.parseInt(vistaAdm.jlblIDI.getText());

            OperationResult or = empDAO.cambiarEstadoEmpleado(id_emp);

            if (or.getOperationStatus() == 1) {

                boolean nuevoEstado = (boolean) or.getData().get("nuevoEstado");

                if (nuevoEstado) {
                    vistaAdm.jlblEstadoI.setForeground(new Color(0, 200, 0));
                    vistaAdm.jlblEstadoI.setText("ACTIVO");
                } else {
                    vistaAdm.jlblEstadoI.setForeground(Color.RED);
                    vistaAdm.jlblEstadoI.setText("INACTIVO");
                }

            }

            vistaAdm.mostrarMensaje(or.getMessage());

        } else if (e.getSource() == vistaAdm.jbtnCambiarContrasenia) {

            int id_emp = Integer.parseInt(vistaAdm.jlblIDI.getText());

            String nuevaContrasenia = JOptionPane.showInputDialog(null, "Ingrese la nueva contraseña:", "Cambio de Contraseña", JOptionPane.PLAIN_MESSAGE);

            if (nuevaContrasenia != null && !nuevaContrasenia.trim().isEmpty()) {
                
                OperationResult or = creDAO.cambiarContrasenia(id_emp, nuevaContrasenia);

                if (or.getOperationStatus() == 1) {
                    JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, or.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.");
            }

        }

    }

    public void cargarEmpleados() {

        OperationResult or = empDAO.obtenerListaEmpleadoConRol();

        listaEmp = (ArrayList<Employee>) or.getData().get("ListaEmpleado");

        DefaultTableModel model = (DefaultTableModel) vistaAdm.jtblEmpleados.getModel();

        model.setRowCount(0);

        listaEmp.stream()
                .forEach(e -> {

                    Object[] rowData = {
                        e.getIdEmpleado(),
                        e.getRol(),
                        e.getNombre() + " "
                        + e.getApellidoP() + " "
                        + e.getApellidoM()

                    };
                    model.addRow(rowData);

                });

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (e.getValueIsAdjusting()) {

            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                int selectedRow = lsm.getMinSelectionIndex();

                if (selectedRow != -1) {

                    if (lsm == vistaAdm.jtblEmpleados.getSelectionModel()) {

                        int id_emp = (Integer) vistaAdm.jtblEmpleados.getValueAt(selectedRow, 0);

                        OperationResult or1 = empDAO.obtenerEmpleado(id_emp, RetornoDeInformacionEmpleado.DATOS_COMUNICACION);

                        OperationResult or2 = creDAO.obtenerUsername(id_emp);

                        Employee emp = (Employee) or1.getData().get("Empleado");

                        vistaAdm.jlblNombreCI.setText(vistaAdm.jtblEmpleados.getValueAt(selectedRow, 2).toString());
                        vistaAdm.jlblRolI.setText(vistaAdm.jtblEmpleados.getValueAt(selectedRow, 1).toString());
                        vistaAdm.jlblDniI.setText(emp.getDni());
                        vistaAdm.jlblTelefonoI.setText(emp.getTelefono());
                        vistaAdm.jlblIDI.setText(String.valueOf(id_emp));
                        vistaAdm.jlblUsernameI.setText(or2.getData().get("username").toString());

                        if (emp.isEstado()) {
                            vistaAdm.jlblEstadoI.setForeground(new Color(0, 200, 0));
                            vistaAdm.jlblEstadoI.setText("ACTIVO");
                        } else {
                            vistaAdm.jlblEstadoI.setForeground(Color.RED);
                            vistaAdm.jlblEstadoI.setText("INACTIVO");
                        }

                    }

                }
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
