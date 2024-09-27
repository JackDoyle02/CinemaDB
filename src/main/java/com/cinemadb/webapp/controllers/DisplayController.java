package com.cinemadb.webapp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinemadb.webapp.models.Actor;
import com.cinemadb.webapp.models.Director;
import com.cinemadb.webapp.models.Genre;
import com.cinemadb.webapp.models.Movie;
import com.cinemadb.webapp.models.Review;
import com.cinemadb.webapp.services.ActorService;
import com.cinemadb.webapp.services.DirectorService;
import com.cinemadb.webapp.services.GenreService;
import com.cinemadb.webapp.services.MovieService;
import com.cinemadb.webapp.services.ReviewService;

@Controller
public class DisplayController {
    
    @Autowired
    private ActorService actorService;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/actor/{actorId}")
    public String showActor(@PathVariable Integer actorId, Model model) {
        Actor actor = actorService.getActorById(actorId);
        model.addAttribute("actor", actor);
        return "entries/actor";
    }

    @GetMapping("/director/{directorId}")
    public String showDirector(@PathVariable Integer directorId, Model model) {
        Director director = directorService.getDirectorById(directorId);
        model.addAttribute("director", director);
        return "entries/director";
    }

    @GetMapping("/genre/{genreId}")
    public String showGenre(@PathVariable Integer genreId, Model model) {
        Genre genre = genreService.getGenreById(genreId);
        model.addAttribute("genre", genre);
        return "entries/genre";
    }

    @GetMapping("/movie/{movieId}")
    public String showMovie(@PathVariable Integer movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "entries/movie";
    }

    @PostMapping("movie/review/add")
    public String addReview(@RequestParam String reviewerName, @RequestParam int rating, @RequestParam String reviewText, @RequestParam Integer movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);

        Review review = new Review();
        review.setMovie(movie);
        review.setReviewerName(reviewerName);
        review.setRating(rating);
        review.setReviewText(reviewText);
        review.setCreatedAt(LocalDate.now());
        reviewService.saveReview(review);
        
        return "entries/movie";
    }
}
