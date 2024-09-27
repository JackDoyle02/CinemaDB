package com.cinemadb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cinemadb.webapp.models.Genre;
import com.cinemadb.webapp.repositories.GenreRepository;

@Service
public class GenreService {
    
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> searchGenres(String query) {
        return genreRepository.findByNameContainingIgnoreCase(query);
    }

    public Genre getGenreById(Integer genreId) {
        return genreRepository.findById(genreId).orElse(null);
    }
}
