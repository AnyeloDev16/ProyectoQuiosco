package modelo.entidad;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un rol dentro del sistema.
 * Contiene la información básica de un rol.
 */
@Getter
@Setter
@AllArgsConstructor
public class Role {
    
    private int idRol;
    private String nombreRol;

    
     /**
     * Constructor que inicializa un rol con el ID proporcionado.
     * 
     * @param idRol El ID del rol.
     */
    public Role(int idRol) {
        this.idRol = idRol;
    }
 
}
