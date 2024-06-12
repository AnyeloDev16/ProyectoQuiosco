package modelo.entidad;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

@AllArgsConstructor
@Getter
@Setter
public final class Credencial {
    
    private int idCredencial;
    private int idEmpleado;
    private String username;
    private String password;

    public Credencial(String username, String password){
        this.username = username;
        this.password = hashearContrasenia(password);
    }
    
    public String hashearContrasenia(String password){
        
        int saltos = 12;
        
        return BCrypt.hashpw(password, BCrypt.gensalt(saltos));
        
    }
    
}
