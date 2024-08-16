package com.example.movie_finder.tvseries;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvSeriesServiceImpl implements TvSeriesService {

    private final TvSeriesRepository tvSeriesRepository;

    public TvSeriesServiceImpl(TvSeriesRepository tvSeriesRepository) {
        this.tvSeriesRepository = tvSeriesRepository;
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
}
