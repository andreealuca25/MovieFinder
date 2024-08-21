package com.example.movie_finder.tvseries;

import com.example.movie_finder.actor.Actor;

import java.util.List;

public interface TvSeriesService {
    List<TvSeries> retrieveAllTvSeries();
    TvSeries getTvSeriesById(Long id);
    TvSeries addNewTvSeries(TvSeries tvSeries);
    TvSeries updateTvSeries(Long id, TvSeries updatedTvSeries);
    void deleteTvSeries(Long id);
    TvSeries addActorToTvSeries(Long tvSeriesId, Actor actor);
}
