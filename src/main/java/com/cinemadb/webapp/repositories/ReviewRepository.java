package com.cinemadb.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemadb.webapp.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}

