package modelo.service;

import modelo.dao.OperationResult;
import java.sql.*;
import java.util.HashMap;
import modelo.dao.CredentialDAO;
import modelo.dao.EmployeeDAO;
import modelo.dao.RetornoDeInformacionEmpleado;
import modelo.dao.RoleDAO;
import modelo.entidad.*;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

    private static LoginService instance;
    private EmployeeDAO empDAO;
    private CredentialDAO credDAO;
    private RoleDAO rolDAO;

    private LoginService() {
        this.empDAO = new EmployeeDAO();
        this.credDAO = new CredentialDAO();
        this.rolDAO = new RoleDAO();
    }
    
    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    
    /**
     * Procesa el acceso al sistema con las credenciales proporcionadas.
     * @param crd las credenciales del usuario
     * @return resultado de la operación de acceso
     */
    public OperationResult verificarCredenciales(Credential crd) {

        OperationResult or1 = credDAO.obtenerContrasenia(crd.getUsername());

        if (or1.getOperationStatus() != 1) {
            return new OperationResult(0, or1.getMessage(), null);
        }

        String passHashed = (String) or1.getData().get("password");
        boolean isCorrect = BCrypt.checkpw(crd.getPassword(), passHashed);

        if (!isCorrect) {
            return new OperationResult(-1, "Contraseña incorrecta", null);
        }

        OperationResult or2 = empDAO.obtenerEmpleado((Integer) or1.getData().get("empleado_id"), RetornoDeInformacionEmpleado.INFO_COMPLETA);

        if (or2.getOperationStatus() != 1) {
            return new OperationResult(0, or2.getMessage(), null);
        }

        Employee emp = (Employee) or2.getData().get("Empleado");

        if (!emp.isEstado()) {
            return new OperationResult(-2, "La cuenta del empleado está INACTIVA", null);
        }

        OperationResult or3 = rolDAO.obtenerRol(emp.getIdEmpleado());

        if (or3.getOperationStatus() != 1) {
            return new OperationResult(0, or3.getMessage(), null);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("Empleado", emp);
        map.put("Rol", or3.getData().get("rol_id"));

        return new OperationResult(1, "Ingreso exitoso", map);
        
    }

    
}
