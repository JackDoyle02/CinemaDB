package com.cinemadb.webapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(name = "title", nullable = false)
    @NotNull
    @Size(max = 255)
    private String title;

    @Column(name = "release_year", nullable = false)
    @NotNull
    private Integer releaseYear;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    @NotNull
    private Director director;

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors;

    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> movieGenres;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public Movie() {}

    public Movie(String title, Integer releaseYear, Director director) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Director getDirector() { return director; }
    public void setDirector(Director director) { this.director = director; }

    public List<MovieActor> getMovieActors() { return movieActors; }

    public List<MovieGenre> getMovieGenres() { return movieGenres; }

    public List<Review> getReviews() { return reviews; }
}
