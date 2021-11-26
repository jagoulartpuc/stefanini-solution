package stefanini.booksmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stefanini.booksmanager.domain.Movie;
import stefanini.booksmanager.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie insertMovie(Movie movie) {
        return movieRepository.insert(movie);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.getAll();
    }

    public Movie editMovie(Movie movie) {
        movieRepository.editMovie(movie);
        return movie;
    }

    public boolean deleteMovie(String title) {
        return movieRepository.deleteMovie(title);
    }

    public Movie findMovieByTitle(String title) {
        return movieRepository.getAll().stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst()
                .orElseThrow();
    }
}