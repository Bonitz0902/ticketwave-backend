package com.afs.restapi.controller;

import com.afs.restapi.mappers.MovieResponse;
import com.afs.restapi.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponse> getAllMovies (){
        return movieService.getAllMovies();
    }

    @GetMapping(params = "movieTitle")
    public List<MovieResponse> searchMovie(@RequestParam String movieTitle){
        return movieService.getMovieByTitle(movieTitle);
    }

    @GetMapping("/available")
    public List<MovieResponse> getAllAvailableMovies() {
        return movieService.getAllAvailableMovies();
    }
}
