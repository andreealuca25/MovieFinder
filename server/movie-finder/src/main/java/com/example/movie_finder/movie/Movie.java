package com.example.movie_finder.movie;

import com.example.movie_finder.actor.Actor;
import com.example.movie_finder.util.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Genre genre;
    private Double rating;
    private Date releaseDate;

    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actors;
}
