package modelo.entidad;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class Pago {
    
    private MetodoDePago metodoDePago;
    private double totalCancelado;
    private double vuelto;
    
}
