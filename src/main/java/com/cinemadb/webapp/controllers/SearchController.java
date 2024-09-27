package com.cinemadb.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.cinemadb.webapp.models.Actor;
import com.cinemadb.webapp.models.Director;
import com.cinemadb.webapp.models.Genre;
import com.cinemadb.webapp.models.Movie;

import com.cinemadb.webapp.services.ActorService;
import com.cinemadb.webapp.services.DirectorService;
import com.cinemadb.webapp.services.GenreService;
import com.cinemadb.webapp.services.MovieService;

@Controller
public class SearchController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String showSearchPage(Model model) {
        model.addAttribute("messege", "HOMEPAGE");
        return "search/search"; 
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, @RequestParam String type, Model model) {
        type = type.toLowerCase();
        if(type.equals("actor")) {
            List<Actor> actors = actorService.searchActors(query);
            model.addAttribute("actors", actors);
        } else if(type .equals("director")) {
            List<Director> directors = directorService.searchDirectors(query);
            model.addAttribute("directors", directors);
        } else if(type.equals("genre")) {
            List<Genre> genres = genreService.searchGenres(query);
            model.addAttribute("genres", genres);
        } else if(type.equals("movie")) {
            List<Movie> movies = movieService.searchMovies(query);
            model.addAttribute("movies", movies);
        }
        model.addAttribute("query", query);
        model.addAttribute("type", type);
        return "search/search-results";
    }
}
