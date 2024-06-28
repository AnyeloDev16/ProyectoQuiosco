package modelo.entidad;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DetalleVenta {
    
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;   
    
}
