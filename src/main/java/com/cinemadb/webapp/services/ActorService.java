package com.cinemadb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cinemadb.webapp.models.Actor;
import com.cinemadb.webapp.repositories.ActorRepository;

@Service
public class ActorService {
    
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> searchActors(String query) {
        return actorRepository.findByNameContainingIgnoreCase(query);
    }

    public Actor getActorById(Integer actorId) {
        return actorRepository.findById(actorId).orElse(null);
    }
}
