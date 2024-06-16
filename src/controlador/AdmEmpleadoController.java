package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.dao.EmployeeDAO;
import modelo.dao.OperationResult;
import modelo.entidad.Employee;
import vista.AdministradorVista;
import vista.RegistrarEmpleadoFrm;

public final class AdmEmpleadoController implements MouseListener {

    AdministradorVista vistaAdm;
    Employee modelo;

    EmployeeDAO empDAO;

    public AdmEmpleadoController(AdministradorVista vistaAdm, Employee modelo) {
        this.vistaAdm = vistaAdm;
        this.modelo = modelo;
        this.empDAO = new EmployeeDAO();
        cargarEmpleados();
        this.vistaAdm.jbtnRegitrarNuevoEmpleado.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vistaAdm.jbtnRegitrarNuevoEmpleado) {

            RegistrarEmpleadoFrm vistaRegistrar = new RegistrarEmpleadoFrm(vistaAdm, true);
            AdmRegEmpleadoController ctrlRegEmp = new AdmRegEmpleadoController(vistaRegistrar);
            ctrlRegEmp.iniciarRegistroEmpleado(vistaRegistrar);

        }

    }

    public void cargarEmpleados() {

        OperationResult or = empDAO.obtenerListaEmpleado();

        ArrayList<Employee> listaEmp = (ArrayList<Employee>) or.getData().get("ListaEmpleado");

        DefaultTableModel model = (DefaultTableModel) vistaAdm.jtblEmpleados.getModel();

        model.setRowCount(0);

        listaEmp.stream()
                .forEach(e -> {

                    Object[] rowData = {
                        e.getIdEmpleado(),
                        e.getRol(),
                        e.getNombre() + " " +
                        e.getApellidoP() + " " +
                        e.getApellidoM()

                    };
                    model.addRow(rowData);

                });

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
