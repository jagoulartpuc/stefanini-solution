package stefanini.booksmanager.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import stefanini.booksmanager.domain.Book;
import stefanini.booksmanager.domain.Movie;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class BooksManagerClient {

    private final String BOOKS_URL = "http://localhost:8080/book";
    private final HttpClient client;

    public BooksManagerClient() {
        client = HttpClient.newBuilder().build();
    }

    public List<Book> getBooks() throws IOException, InterruptedException {
        URI uri = URI.create(BOOKS_URL);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        String body = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        TypeReference<List<Book>> books = new TypeReference<>() {};
        return new ObjectMapper().readValue(body, books);
    }
}