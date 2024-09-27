package com.cinemadb.webapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movie_genre")
public class MovieGenre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieGenreId;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    @NotNull
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @NotNull
    private Movie movie;

    public MovieGenre() {}

    public MovieGenre(Movie movie, Genre genre) {
        this.movie = movie;
        this.genre = genre;
    }

    public Integer getMovieGenreId() { return movieGenreId; }
    public void setMovieGenreId(Integer movieGenreId) { this.movieGenreId = movieGenreId; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }
}
