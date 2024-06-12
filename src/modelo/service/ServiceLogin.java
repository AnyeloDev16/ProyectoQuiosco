package modelo.service;

import java.sql.*;
import java.util.HashMap;
import modelo.dao.CredencialDAO;
import modelo.dao.EmpleadoDAO;
import modelo.dao.RolDAO;
import modelo.entidad.*;
import org.mindrot.jbcrypt.BCrypt;

public class ServiceLogin {

    private static ServiceLogin instance;
    private EmpleadoDAO empDAO;
    private CredencialDAO credDAO;
    private RolDAO rolDAO;

    private ServiceLogin() {
        this.empDAO = new EmpleadoDAO();
        this.credDAO = new CredencialDAO();
        this.rolDAO = new RolDAO();
    }
    
    public static ServiceLogin getInstance() {
        if (instance == null) {
            instance = new ServiceLogin();
        }
        return instance;
    }

    public OperationResult accederSistema(Credencial crd) {

        OperationResult or1 = credDAO.obtenerContrasenia(crd.getUsername());

        switch (or1.getEstadoOperation()) {

            case -1, 0 -> {
                return new OperationResult(0, or1.getMensaje(), null);
            }
            case 1 -> {

                String passhashed = (String) or1.getObjeto().get("password");

                boolean isCorrect = BCrypt.checkpw(crd.getPassword(), passhashed);

                if (isCorrect) {

                    OperationResult or2 = empDAO.obtenerEmpleado(((Integer) (or1.getObjeto().get("empleado_id"))).intValue());

                    switch (or2.getEstadoOperation()) {

                        case -1, 0 -> {
                            return new OperationResult(0, or2.getMensaje(), null);
                        }
                        case 1 -> {

                            Empleado emp = (Empleado) or2.getObjeto().get("Empleado");

                            if (emp.isEstado()) {

                                OperationResult or3 = rolDAO.obtenerRol(emp.getIdEmpleado());

                                switch (or3.getEstadoOperation()) {

                                    case -1, 0 -> {
                                        return new OperationResult(0, or3.getMensaje(), null);
                                    }
                                    case 1 -> {

                                        HashMap<String, Object> map = new HashMap<>();

                                        map.put("Empleado", emp);
                                        map.put("Rol", ((Integer) (or3.getObjeto().get("rol_id"))).intValue());

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
