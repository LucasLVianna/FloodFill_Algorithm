import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // IOException verifica erros na hora de ler a imagem, e evita que precise
        // resolver na main, se der problema, ele alerta e para
        System.out.println("Escolha qual imagem você deseja pintar: ");
        System.out.println("1. Rosto, 20x20");
        System.out.println("2. Quadrado dividido, 200x200");
        System.out.print("Sua escolha: ");
        int escolha = scanner.nextInt();

        if(escolha == 1){
            BufferedImage imagemParaFila = ImageIO.read(new File("rosto.png"));
            FloodFill floodFill = new FloodFill();

            floodFill.preencherComFila(imagemParaFila, 10,10,0xFFAA00FF, 1);

            BufferedImage imagemParaPilha = ImageIO.read(new File("rosto.png"));
            floodFill.preencherComPilha(imagemParaPilha, 7 , 5, 0xFFAA00FF, 1);
        }else if(escolha == 2){
            BufferedImage imagemParaFila = ImageIO.read(new File("matriz.png"));

            FloodFill floodFill = new FloodFill();

            floodFill.preencherComFila(imagemParaFila, 20,30,0xFFAA00FF, 100);

            BufferedImage imagemParaPilha = ImageIO.read(new File("matriz.png"));
            floodFill.preencherComPilha(imagemParaPilha, 150, 130, 0xFFAA00FF, 100);
        }else{
            System.out.println("Escolha inválida!");
        }
    }
}
