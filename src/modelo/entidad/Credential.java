package modelo.entidad;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Clase que representa las credenciales de un usuario. Contiene el nombre de
 * usuario y la contraseña.
 */
@AllArgsConstructor
@Getter
@Setter
public final class Credential {

    private String username;
    private String password;

    /**
     * Método estático para hashear una contraseña usando BCrypt.
     *
     * @param password La contraseña en texto plano.
     * @return La contraseña hasheada.
     */
    public static String hashPassword(String password) {

        int saltos = 12;

        return BCrypt.hashpw(password, BCrypt.gensalt(saltos));

    }

}
