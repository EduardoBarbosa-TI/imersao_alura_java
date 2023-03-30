
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {


        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        ClientHttp http =  new ClientHttp();
        String json = http.buscaDados(url);



        var geradora = new StickerFactory();
        for (Map<String,String> conteudo : listaDeConteudos){

            String urlImage = conteudo.get("image")
                    .replaceAll("(@+)(.*).jpg$","$1.jpg");


            InputStream inputStream = new URL(urlImage).openStream();
            String nomeArquivo = titulo + ".png";


            geradora.store(inputStream,nomeArquivo);


            System.out.println(titulo);
            System.out.println();
        }
    }

}