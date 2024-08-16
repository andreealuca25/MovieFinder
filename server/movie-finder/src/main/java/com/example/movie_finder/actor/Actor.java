package com.example.movie_finder.actor;

import com.example.movie_finder.movie.Movie;
import com.example.movie_finder.tvseries.TvSeries;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "actors")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @ManyToMany
    @JoinTable(
            name = "actor_movies",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movieList;

    @ManyToMany
    @JoinTable(
            name = "actor_tvseries",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "tvseries_id")
    )
    private List<TvSeries> tvSeriesList;
}
