package vista.tipografia;

import java.awt.Font;
import java.io.InputStream;

public class Tipografia {
    
    private Font font = null;
    public final String ROBOTO = "Roboto-Regular.ttf";
    
    public Font fuente(String fontName, int estilo, float tamanio) {
        
        try(InputStream is = getClass().getResourceAsStream(fontName)){
            
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            
        } catch (Exception ex) {
        
            font = new Font("Arial", Font.PLAIN, 14);
            
        }
        
        Font tfont = font.deriveFont(estilo,tamanio);
        return tfont;
        
    }
    
}
