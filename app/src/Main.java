
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {


        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=10";


        var http =  new ClientHttp();
        String json = http.buscaDados(url);


        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);


        var geradora = new StickerFactory();

        for (int i = 0; i < 3; i++){

            Conteudo conteudo =  conteudos.get(i);

            var inputStream = new URL(conteudo.getUrlImage()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";


            geradora.store(inputStream,nomeArquivo);


            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }

}