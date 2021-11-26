package stefanini.booksmanager.repository;

import org.springframework.stereotype.Repository;
import stefanini.booksmanager.domain.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    public Movie insert(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public List<Movie> getAll() {
        return movies;
    }

    public Movie getMovieByTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .findFirst()
                .orElseThrow();
    }

    public Movie editMovie(Movie movie) {
        Movie oldMovie = getMovieByTitle(movie.getTitle());
        return movies.set(movies.indexOf(oldMovie), movie);
    }

    public boolean deleteMovie(String title) {
        try {
            movies.remove(getMovieByTitle(title));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
