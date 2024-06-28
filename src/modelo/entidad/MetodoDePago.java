package modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetodoDePago {
    
    private int idMetodoPago;
    private String metodoPago;

    public MetodoDePago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public MetodoDePago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
}
