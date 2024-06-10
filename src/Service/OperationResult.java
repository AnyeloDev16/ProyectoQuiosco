package Service;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OperationResult {
    
    private int estadoOperation;
    private String mensaje;
    private HashMap<String, Object> objeto; 
    
}
