package com.cinemadb.webapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    @Column(name = "name", nullable = false)
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @OneToMany(mappedBy = "genre")
    private List<MovieGenre> movieGenres;

    public Genre() {}

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getGenreId() { return genreId; }
    public void setGenreId(Integer genreId) { this.genreId = genreId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<MovieGenre> getMovieGenres() { return movieGenres; }
}
