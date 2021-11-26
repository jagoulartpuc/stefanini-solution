package stefanini.booksmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stefanini.booksmanager.client.BooksManagerClient;
import stefanini.booksmanager.domain.Book;
import stefanini.booksmanager.domain.Fantasy;
import stefanini.booksmanager.domain.Movie;
import stefanini.booksmanager.repository.MovieRepository;

import java.io.IOException;

@Service
public class FantasyService {

    @Autowired
    private BooksManagerClient booksManagerClient;

    @Autowired
    private MovieRepository movieRepository;

    public Fantasy findFantasyByTitle(String title) throws IOException, InterruptedException {
        Book book = getBook(title);
        return Fantasy.builder()
                .movie(getMovie(title))
                .book(book)
                .build();
    }

    private Book getBook(String title) throws IOException, InterruptedException {
        return booksManagerClient.getBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst()
                .orElseThrow();
    }
    private Movie getMovie(String title) {
        return movieRepository.getAll().stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst()
                .orElseThrow();
    }
}
