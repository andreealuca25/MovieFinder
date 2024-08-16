package com.example.movie_finder.tvseries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvSeriesRepository extends CrudRepository<TvSeries, Long> {
}
