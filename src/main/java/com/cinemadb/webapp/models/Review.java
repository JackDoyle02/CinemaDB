package com.cinemadb.webapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "review")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @NotNull
    private Movie movie;

    @Column(name = "reviewer_name", nullable = false)
    @NotNull
    @Size(max = 100)
    private String reviewerName = "Guest";

    @Column(name = "review_text", nullable = false)
    @NotNull
    @Size(max = 255)
    private String reviewText;

    @Column(name = "rating", nullable = false)
    @NotNull
    private Integer rating;

    @Column(name = "created_at", nullable = false)
    @NotNull
    private LocalDate createdAt;

    public Review() {
        this.reviewerName = "Guest";
    }

    public Review(Movie movie, String reviewerName, Integer rating, String reviewText) {
        this.movie = movie;
        this.reviewerName = reviewerName != null ? reviewerName : "Guest";
        this.rating = rating;
        this.reviewText = reviewText;
        this.createdAt = LocalDate.now();
    }

    // Getters and Setters
    public Integer getReviewId() { return reviewId; }
    public void setReviewId(Integer reviewId) { this.reviewId = reviewId; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getReviewText() { return reviewText; }
    public void setReviewText(String reviewText) { this.reviewText = reviewText; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
}
