package modelo.entidad;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Venta {
    
    private int idVenta;
    private String nombreEmpleado;
    private double ventaTotal;
    private LocalDateTime ventaFecha;
    private String metodoPago;
    
}
