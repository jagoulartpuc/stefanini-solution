package stefanini.booksmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stefanini.booksmanager.domain.Movie;
import stefanini.booksmanager.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie postMovie(
            @RequestBody Movie movie
    ) {
        return movieService.insertMovie(movie);
    }

    @GetMapping
    public List<Movie> findMovies(
    ) {
        return movieService.findAllMovies();
    }

    @GetMapping("/search")
    public Movie findMovieByTitle(
            @RequestParam String title
    ) {
        return movieService.findMovieByTitle(title);
    }

    @PutMapping
    public Movie editBook(
            @RequestBody Movie movie
    ) {
        return movieService.editMovie(movie);
    }

    @DeleteMapping("/{title}")
    public boolean deleteMovie(
            @PathVariable String title
    ) {
        return movieService.deleteMovie(title);
    }
}
