package modelo.entidad;

import javax.swing.ImageIcon;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    
    private int idProducto;
    private String nombreProducto;
    private double PrecioCompra;
    private double PrecioVenta;
    private int cantidad;
    private ImageIcon foto;

    @Builder
    public Product(int idProducto, String nombreProducto, double PrecioCompra, double PrecioVenta, int cantidad, ImageIcon foto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.cantidad = cantidad;
        this.foto = foto;
    }
    
    
    
}
