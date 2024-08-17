package com.example.movie_finder.tvseries;

import com.example.movie_finder.actor.Actor;
import com.example.movie_finder.util.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tvseries")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TvSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory.")
    private String title;
    @NotBlank(message = "Description is mandatory.")
    private String description;
    @NotBlank(message = "Genre is mandatory.")
    private Genre genre;
    @NotBlank(message = "Rating is mandatory.")
    private Double rating;
    @NotBlank(message = "Release date is mandatory.")
    private Date releaseDate;
    private int seasonsNumber;
    private int episodesNumber;

    @ManyToMany(mappedBy = "tvSeriesList")
    private List<Actor> actors;
}
