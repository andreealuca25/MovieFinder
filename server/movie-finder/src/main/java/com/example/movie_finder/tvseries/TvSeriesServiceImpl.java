package com.example.movie_finder.tvseries;

import com.example.movie_finder.actor.Actor;
import com.example.movie_finder.actor.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TvSeriesServiceImpl implements TvSeriesService {

    private final TvSeriesRepository tvSeriesRepository;
    private final ActorRepository actorRepository;

    public TvSeriesServiceImpl(TvSeriesRepository tvSeriesRepository, ActorRepository actorRepository) {
        this.tvSeriesRepository = tvSeriesRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public List<TvSeries> retrieveAllTvSeries() {
        return (List<TvSeries>) tvSeriesRepository.findAll();
    }

    @Override
    public TvSeries getTvSeriesById(Long id) {
        return tvSeriesRepository.findById(id).orElse(null);
    }

    @Override
    public TvSeries addNewTvSeries(TvSeries tvSeries) {
        return tvSeriesRepository.save(tvSeries);
    }

    @Override
    public TvSeries updateTvSeries(Long id, TvSeries updatedTvSeries) {
        return tvSeriesRepository.findById(id).map(tvSeries -> {
            tvSeries.setTitle(updatedTvSeries.getTitle());
            tvSeries.setDescription(updatedTvSeries.getDescription());
            tvSeries.setGenre(updatedTvSeries.getGenre());
            tvSeries.setRating(updatedTvSeries.getRating());
            tvSeries.setReleaseDate(updatedTvSeries.getReleaseDate());
            tvSeries.setSeasonsNumber(updatedTvSeries.getSeasonsNumber());
            tvSeries.setEpisodesNumber(updatedTvSeries.getEpisodesNumber());
            tvSeries.setActors(updatedTvSeries.getActors());
            return tvSeriesRepository.save(tvSeries);
        }).orElse(null);
    }

    @Override
    public void deleteTvSeries(Long id) {
        tvSeriesRepository.deleteById(id);
    }

    @Override
    public TvSeries addActorToTvSeries(Long tvSeriesId, Actor actor) {
        Optional<TvSeries> movie = tvSeriesRepository.findById(tvSeriesId);
        if (movie.isPresent()) {
            TvSeries tvSeriesToAdd = movie.get();

            if (actor.getMovieList() == null) {
                actor.setMovieList(new ArrayList<>());
            }

            actor.getTvSeriesList().add(tvSeriesToAdd);
            tvSeriesToAdd.getActors().add(actor);
            actorRepository.save(actor);

            return tvSeriesRepository.save(tvSeriesToAdd);
        }
        return null;
    }
}
