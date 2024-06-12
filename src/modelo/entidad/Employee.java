package modelo.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un empleado. Contiene la información básica de un
 * empleado.
 */
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    private int idEmpleado;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String dni;
    private boolean estado;

    /**
     * Constructor que inicializa un empleado nuevo con los datos
     * proporcionados.
     *
     * @param nombre El nombre del empleado.
     * @param apellidoP El apellido paterno del empleado.
     * @param apellidoM El apellido materno del empleado.
     * @param telefono El número de teléfono del empleado.
     * @param dni El DNI del empleado.
     */
    public Employee(String nombre, String apellidoP, String apellidoM, String telefono, String dni) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.dni = dni;
    }

    /**
     * Constructor que inicializa un empleado con los datos básicos necesarios para la venta.
     * 
     * @param idEmpleado El ID del empleado.
     * @param nombre El nombre del empleado.
     * @param apellidoP El apellido paterno del empleado.
     * @param apellidoM El apellido materno del empleado.
     */
    public Employee(int idEmpleado, String nombre, String apellidoP, String apellidoM) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

}
