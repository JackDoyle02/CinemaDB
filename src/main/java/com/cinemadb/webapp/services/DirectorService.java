package com.cinemadb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cinemadb.webapp.models.Director;
import com.cinemadb.webapp.repositories.DirectorRepository;

@Service
public class DirectorService {
    
    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> searchDirectors(String query) {
        return directorRepository.findByNameContainingIgnoreCase(query);
    }

    public Director getDirectorById(Integer directorId) {
        return directorRepository.findById(directorId).orElse(null);
    }
}
