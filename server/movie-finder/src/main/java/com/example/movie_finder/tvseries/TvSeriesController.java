package com.example.movie_finder.tvseries;

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
    public TvSeries addTvSeries(@RequestBody TvSeries tvSeries) {
        return tvSeriesService.addNewTvSeries(tvSeries);
    }

    @PutMapping("/update/{id}")
    public TvSeries updateTvSeries(@PathVariable Long id, @RequestBody TvSeries updatedTvSeries) {
        return tvSeriesService.updateTvSeries(id, updatedTvSeries);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTvSeries(@PathVariable Long id) {
        tvSeriesService.deleteTvSeries(id);
    }
}
