import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class stickerFactory {

    public void store() throws Exception {
        //leitura da imagem
        BufferedImage imageOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        //Criar nova imagem em meória com transparência e com tamanho novo
        int largura = imageOriginal.getWidth();
        int altura = imageOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);

        ImageIO.write(novaImagem,"png", new File("saida/figura.png"));
    }

    public static void main(String[] args) throws Exception {
        var gerador = new stickerFactory();
        gerador.store();
    }
}
