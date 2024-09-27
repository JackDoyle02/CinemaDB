package com.cinemadb.webapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movie_actor")
public class MovieActor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieActorId;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    @NotNull
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @NotNull
    private Movie movie;

    public MovieActor() {}

    public MovieActor(Movie movie, Actor actor) {
        this.movie = movie;
        this.actor = actor;
    }

    public Integer getMovieActorId() { return movieActorId; }
    public void setMovieActorId(Integer movieActorId) { this.movieActorId = movieActorId; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Actor getActor() { return actor; }
    public void setActor(Actor actor) { this.actor = actor; }
}

