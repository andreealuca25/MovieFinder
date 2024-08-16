package com.example.movie_finder.movie;

import java.util.List;

public interface MovieService {
    List<Movie> retrieveAllMovies();
    Movie getMovieById(Long id);
    Movie addNewMovie(Movie movie);
    Movie updateMovie(Long id, Movie updatedMovie);
    void deleteMovie(Long id);
}
