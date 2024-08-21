package com.example.movie_finder.movie;

import com.example.movie_finder.actor.Actor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.retrieveAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/add")
    public Movie addMovie(@Valid @RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
    }

    @PutMapping("/update/{id}")
    public Movie updateMovie(@PathVariable Long id, @Valid @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(id, updatedMovie);
    }

    @PutMapping("/add-actor/{movie-id}")
    public Movie addActor(@PathVariable(name="movie-id") Long movieId, @Valid @RequestBody Actor actor) {
        return movieService.addActorToMovie(movieId, actor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
