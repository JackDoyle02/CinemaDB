package com.cinemadb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cinemadb.webapp.models.Movie;
import com.cinemadb.webapp.repositories.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> searchMovies(String query) {
        return movieRepository.findByTitleContainingIgnoreCase(query);
    }

    public Movie getMovieById(Integer movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}
