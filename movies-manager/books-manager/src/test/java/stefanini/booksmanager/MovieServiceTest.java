package stefanini.booksmanager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stefanini.booksmanager.domain.Movie;
import stefanini.booksmanager.repository.MovieRepository;
import stefanini.booksmanager.service.MovieService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService service;

    @Mock
    private MovieRepository repository;

    @Test
    public void bookServiceShouldInsertBook() {
        Movie movie = Movie.builder()
                .title("Harry Potter and the Philosopher's Stone")
                .author("J. K. Rowling")
                .country("United Kingdom")
                .releaseDate("26 June 1997")
                .cinematography("Bloomsbury (UK)")
                .build();

        given(repository.insert(movie)).willReturn(movie);

        service.insertMovie(movie);
        Assert.assertEquals(service.insertMovie(movie), repository.insert(movie));
    }

    @Test
    public void bookServiceShouldlistBooks() {
        Movie movie1 = Movie.builder().build();
        Movie movie2 = Movie.builder().build();
        Movie movie3 = Movie.builder().build();

        given(repository.getAll()).willReturn(Arrays.asList(movie1, movie2, movie3));

        List<Movie> moviesReturned = service.findAllMovies();
        Assert.assertEquals(Arrays.asList(movie1, movie2, movie3), moviesReturned);
    }

    @Test
    public void toolServiceShouldDeleteBook() {
        String title = "Harry Potter and the Philosopher's Stone";

        Movie movie = Movie.builder().title(title).build();
        service.insertMovie(movie);
        service.deleteMovie(title);
        assertTrue(service.findAllMovies().isEmpty());
    }
}
