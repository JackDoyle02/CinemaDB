package com.cinemadb.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cinemadb.webapp.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByNameContainingIgnoreCase(String name);
}
