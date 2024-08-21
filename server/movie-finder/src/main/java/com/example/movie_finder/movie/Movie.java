package com.example.movie_finder.movie;

import com.example.movie_finder.actor.Actor;
import com.example.movie_finder.util.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Title is mandatory.")
    private String title;
    @NotBlank(message = "Description is mandatory.")
    private String description;
    @NotNull(message = "Genre is mandatory.")
    @Enumerated(EnumType.ORDINAL)
    private Genre genre;
    @NotNull(message = "Rating is mandatory.")
    private Double rating;
    @NotNull(message = "Release date is mandatory.")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actors;
}
