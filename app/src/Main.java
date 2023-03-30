import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {


        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listadeFilmes = parser.parse(body);
        for (Map<String,String> Filme : listadeFilmes){
            System.out.println(Filme.get("title"));
            System.out.println(Filme.get("image"));
            System.out.println(Filme.get("imDbRating"));
            System.out.println();
        }
    }

}