package modelo.dao;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa el resultado de una operación en la base de datos.
 */
@AllArgsConstructor
@Getter
@Setter
public class OperationResult {
    
    private int operationStatus;
    private String message;
    private HashMap<String, Object> data; 
    
}
