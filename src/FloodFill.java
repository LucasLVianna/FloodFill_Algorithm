import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FloodFill {
    public void preencherComFila(BufferedImage imagem, int x, int y, int novaCor) throws IOException {
        Fila fila = new Fila();

        Coordenada inicio = new Coordenada(x,y);
        fila.enfileirar(inicio);

        int corPintar = novaCor;

        int corFundo = imagem.getRGB(x, y);
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        int contador = 1;

        new File("frames_fila").mkdirs();

        while(!fila.verificaVazia()){
            Coordenada p = fila.desenfileirar();
            if(p.x < 0 || p.x >= largura || p.y < 0 || p.y >= altura){
                continue;
            }

            if(imagem.getRGB(p.x, p.y) != corFundo){
                continue;
            }

            imagem.setRGB(p.x, p.y, corPintar);
            if(contador % 100 == 0){
                ImageIO.write(imagem, "png", new File("frames_fila/frame_"+contador+".png"));
            }
            contador++;
            fila.enfileirar(new Coordenada (p.x, p.y+1));
            fila.enfileirar(new Coordenada (p.x, p.y-1));
            fila.enfileirar(new Coordenada (p.x+1, p.y));
            fila.enfileirar(new Coordenada (p.x-1, p.y));
        }

        ImageIO.write(imagem, "png", new File("resultado_fila.png"));

        System.out.println("Imagem pintada com fila com sucesso!");
    }

    public void preencherComPilha(BufferedImage imagem, int x, int y, int novaCor) throws IOException {
        Pilha pilha = new Pilha();

        Coordenada inicio = new Coordenada(x, y);
        pilha.empilhar(inicio);

        int corPintar = novaCor;

        int corFundo = imagem.getRGB(x,y);
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        int contador = 1;

        new File("frames_pilha").mkdirs();

        while(!pilha.verificaVazia()){
            Coordenada p = pilha.desempilhar();
            if(p.x < 0 || p.x >= largura || p.y < 0 || p.y >= altura){
                continue;
            }

            if(imagem.getRGB(p.x, p.y) != corFundo){
                continue;
            }

            imagem.setRGB(p.x, p.y, corPintar);
            if(contador % 100 == 0){
                ImageIO.write(imagem, "png", new File("frames_pilha/frame_"+contador+".png"));
            }
            contador++;
            pilha.empilhar(new Coordenada (p.x, p.y+1));
            pilha.empilhar(new Coordenada (p.x, p.y-1));
            pilha.empilhar(new Coordenada (p.x+1, p.y));
            pilha.empilhar(new Coordenada (p.x-1, p.y));
        }

        ImageIO.write(imagem, "png", new File("resultado_pilha.png"));

        System.out.println("Imagem pintada com pilha com sucesso!");
    }
}
