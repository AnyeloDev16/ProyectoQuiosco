package modelo.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Empleado {
    
    private int idEmpleado;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String dni;
    private boolean estado;

    //registra empleado nuevo
    public Empleado(String nombre, String apellidoP, String apellidoM, String telefono, String dni) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.dni = dni;
    }

    // colocarlo en venta
    public Empleado(int idEmpleado, String nombre, String apellidoP, String apellidoM) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }
   
}
