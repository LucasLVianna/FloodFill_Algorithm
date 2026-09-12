import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // IOException verifica erros na hora de ler a imagem, e evita que precise
        // resolver na main, se der problema, ele alerta e para

        BufferedImage imagemParaFila = ImageIO.read(new File("matriz.png"));
        FloodFill floodFill = new FloodFill();

        floodFill.preencherComFila(imagemParaFila, 10,10,0xFFAA00FF);

        BufferedImage imagemParaPilha = ImageIO.read(new File("matriz.png"));
        floodFill.preencherComPilha(imagemParaPilha, 150 , 150, 0xFFAA00FF);
    }
}
