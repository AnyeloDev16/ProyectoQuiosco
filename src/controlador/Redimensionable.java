package controlador;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public interface Redimensionable {
    
    public default ImageIcon redimensionar(String archivo, int Width, int Height) {
        try {

            BufferedImage originalImage = ImageIO.read(new File(archivo));

            int newWidth = Width; // Nueva anchura
            int newHeight = Height; // Nueva altura
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImage);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public default ImageIcon redimensionar(ImageIcon imagen, int Width, int Height) {
        try {
            Image originalImage = imagen.getImage();

            int newWidth = Width; // Nueva anchura
            int newHeight = Height; // Nueva altura
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImage);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null; // Manejar el error devolviendo un valor predeterminado o null
        }
    }
}
