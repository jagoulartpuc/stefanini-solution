package stefanini.booksmanager.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import stefanini.booksmanager.domain.Movie;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class MoviesManagerClient {

    private final String MOVIES_URL = "http://localhost:8081/movie";
    private final HttpClient client;

    public MoviesManagerClient() {
        client = HttpClient.newBuilder().build();
    }

    public List<Movie> getMovies() throws IOException, InterruptedException {
        URI uri = URI.create(MOVIES_URL);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        String body = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        TypeReference<List<Movie>> movies = new TypeReference<>() {};
        return new ObjectMapper().readValue(body, movies);
    }
}
