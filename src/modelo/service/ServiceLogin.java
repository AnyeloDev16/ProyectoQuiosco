package modelo.service;

import modelo.dao.OperationResult;
import java.sql.*;
import java.util.HashMap;
import modelo.dao.CredentialDAO;
import modelo.dao.EmployeeDAO;
import modelo.dao.RoleDAO;
import modelo.entidad.*;
import org.mindrot.jbcrypt.BCrypt;

public class ServiceLogin {

    private static ServiceLogin instance;
    private EmployeeDAO empDAO;
    private CredentialDAO credDAO;
    private RoleDAO rolDAO;

    private ServiceLogin() {
        this.empDAO = new EmployeeDAO();
        this.credDAO = new CredentialDAO();
        this.rolDAO = new RoleDAO();
    }
    
    public static ServiceLogin getInstance() {
        if (instance == null) {
            instance = new ServiceLogin();
        }
        return instance;
    }

    public OperationResult accederSistema(Credential crd) {

        OperationResult or1 = credDAO.obtenerContrasenia(crd.getUsername());

        switch (or1.getOperationStatus()) {

            case -1, 0 -> {
                return new OperationResult(0, or1.getMessage(), null);
            }
            case 1 -> {

                String passhashed = (String) or1.getData().get("password");

                boolean isCorrect = BCrypt.checkpw(crd.getPassword(), passhashed);

                if (isCorrect) {

                    OperationResult or2 = empDAO.obtenerEmpleado(((Integer) (or1.getData().get("empleado_id"))).intValue());

                    switch (or2.getOperationStatus()) {

                        case -1, 0 -> {
                            return new OperationResult(0, or2.getMessage(), null);
                        }
                        case 1 -> {

                            Employee emp = (Employee) or2.getData().get("Empleado");

                            if (emp.isEstado()) {

                                OperationResult or3 = rolDAO.obtenerRol(emp.getIdEmpleado());

                                switch (or3.getOperationStatus()) {

                                    case -1, 0 -> {
                                        return new OperationResult(0, or3.getMessage(), null);
                                    }
                                    case 1 -> {

                                        HashMap<String, Object> map = new HashMap<>();

                                        map.put("Empleado", emp);
                                        map.put("Rol", ((Integer) (or3.getData().get("rol_id"))).intValue());

                                        return new OperationResult(1, "Ingreso exitoso", map);

                                    }
                                }
                            } else {
                                return new OperationResult(-2, "La cuenta del empleado se ecnuentra INACTIVO", null);
                            }

                        }
                    }

                } else {

                    return new OperationResult(-1, "Contraseña incorrecta", null);

                }
            }

        }

        return new OperationResult(0, "", null);
        
    }

}
