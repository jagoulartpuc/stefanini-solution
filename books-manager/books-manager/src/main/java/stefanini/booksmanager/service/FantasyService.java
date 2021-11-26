package stefanini.booksmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stefanini.booksmanager.domain.Movie;
import stefanini.booksmanager.client.MoviesManagerClient;
import stefanini.booksmanager.domain.Book;
import stefanini.booksmanager.domain.Fantasy;
import stefanini.booksmanager.repository.BookRepository;

import java.io.IOException;

@Service
public class FantasyService {

    @Autowired
    private MoviesManagerClient moviesManagerClient;

    @Autowired
    private BookRepository bookRepository;

    public Fantasy findFantasyByTitle(String title) throws IOException, InterruptedException {
        Movie movie = getMovie(title);
        return Fantasy.builder()
                .movie(movie)
                .book(getBook(title))
                .build();
    }

    private Movie getMovie(String title) throws IOException, InterruptedException {
        return moviesManagerClient.getMovies().stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst()
                .orElseThrow();
    }

    private Book getBook(String title) {
        return bookRepository.getAll().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst()
                .orElseThrow();
    }
}
