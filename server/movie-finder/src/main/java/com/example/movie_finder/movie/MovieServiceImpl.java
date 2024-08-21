package com.example.movie_finder.movie;

import com.example.movie_finder.actor.Actor;
import com.example.movie_finder.actor.ActorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Movie> retrieveAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie addNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie updatedMovie) {
        return movieRepository.findById(id).map(movie -> {
            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setGenre(updatedMovie.getGenre());
            movie.setRating(updatedMovie.getRating());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            movie.setActors(updatedMovie.getActors());
            return movieRepository.save(movie);
        }).orElse(null);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Movie addActorToMovie(Long movieId, Actor actor) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            Movie movieToAdd = movie.get();

            if (actor.getMovieList() == null) {
                actor.setMovieList(new ArrayList<>());
            }

            actor.getMovieList().add(movieToAdd);
            movieToAdd.getActors().add(actor);
            actorRepository.save(actor);

            return movieRepository.save(movieToAdd);
        }
        return null;
    }


}
