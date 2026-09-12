import java.awt.image.BufferedImage;

public class FloodFill {
    public void preencherComFila(BufferedImage imagem, int x, int y, int novaCor){
        Fila fila = new Fila();

        Coordenada inicio = new Coordenada(x,y);
        fila.enfileirar(inicio);

        int corPintar = novaCor;

        int corFundo = imagem.getRGB(x, y);
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        while(!fila.verificaVazia()){
            Coordenada p = fila.desenfileirar();
            if(p.x < 0 || p.x >= largura || p.y < 0 || p.y >= altura){
                continue;
            }

            if(imagem.getRGB(p.x, p.y) != corFundo){
                continue;
            }

            imagem.setRGB(p.x, p.y, corPintar);
            fila.enfileirar(new Coordenada (p.x, p.y+1));
            fila.enfileirar(new Coordenada (p.x, p.y-1));
            fila.enfileirar(new Coordenada (p.x+1, p.y));
            fila.enfileirar(new Coordenada (p.x-1, p.y));
        }
    }
}
