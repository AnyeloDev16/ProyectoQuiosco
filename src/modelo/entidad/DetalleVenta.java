package modelo.entidad;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DetalleVenta {
    
    private Product producto;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;   
    
}
