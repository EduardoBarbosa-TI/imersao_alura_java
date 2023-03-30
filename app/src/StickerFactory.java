import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


public class StickerFactory {

    public void store(InputStream inputStream, String nomeArquivo) throws Exception {
        //leitura da imagem
        BufferedImage imageOriginal = ImageIO.read(inputStream);

        //Criar nova imagem em meória com transparência e com tamanho novo
        int largura = imageOriginal.getWidth();
        int altura = imageOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);

        // configurar a fonte
        var fonte =new Font(Font.SANS_SERIF, Font.BOLD, 52);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        //escrever uma frasse na nova imagem
        graphics.drawString("TOPZERA",200,novaAltura - 100);


        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem,"png", new File("saida/" + nomeArquivo));
    }
}
