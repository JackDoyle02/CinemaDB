package com.cinemadb.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cinemadb.webapp.models.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    List<Director> findByNameContainingIgnoreCase(String name);
}

