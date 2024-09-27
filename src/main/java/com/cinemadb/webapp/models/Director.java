package com.cinemadb.webapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer directorId;

    @Column(name = "name", nullable = false)
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(name = "biography")
    @Size(max = 255)
    private String biography;

    @Column(name = "dob", nullable = false)
    @NotNull
    private LocalDate dob;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director() {}

    public Director(String name, LocalDate dob, String biography) {
        this.name = name;
        this.biography = biography;
        this.dob = dob;
    }

    public Integer getDirectorId() { return directorId; }
    public void setDirectorId(Integer directorId) { this.directorId = directorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }
    
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public List<Movie> getMovies() { return movies; }
}
