package modelo.entidad;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Credencial {
    
    private int idCredencial;
    private int idEmpleado;
    private String username;
    private String password;

    public Credencial(String username, String password){
        this.username = username;
        this.password = password;
    }
    
}
