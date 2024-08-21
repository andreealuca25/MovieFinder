package com.example.movie_finder.tvseries;

import com.example.movie_finder.actor.Actor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tvSeries")
public class TvSeriesController {

    private final TvSeriesService tvSeriesService;

    public TvSeriesController(TvSeriesService tvSeriesService) {
        this.tvSeriesService = tvSeriesService;
    }

    @GetMapping
    public List<TvSeries> getAllTvSeries() {
        return tvSeriesService.retrieveAllTvSeries();
    }

    @GetMapping("/{id}")
    public TvSeries getTvSeriesById(@PathVariable Long id) {
        return tvSeriesService.getTvSeriesById(id);
    }

    @PostMapping("/add")
    public TvSeries addTvSeries(@Valid @RequestBody TvSeries tvSeries) {
        return tvSeriesService.addNewTvSeries(tvSeries);
    }

    @PutMapping("/update/{id}")
    public TvSeries updateTvSeries(@PathVariable Long id, @Valid @RequestBody TvSeries updatedTvSeries) {
        return tvSeriesService.updateTvSeries(id, updatedTvSeries);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTvSeries(@PathVariable Long id) {
        tvSeriesService.deleteTvSeries(id);
    }

    @PutMapping("/add-actor/{tvseries-id}")
    public TvSeries addActor(@PathVariable(name="tvseries-id") Long tvSeriesId, @Valid @RequestBody Actor actor) {
        return tvSeriesService.addActorToTvSeries(tvSeriesId, actor);
    }
}
