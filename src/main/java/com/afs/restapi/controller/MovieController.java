package com.afs.restapi.controller;

import com.afs.restapi.mappers.MovieResponse;
import com.afs.restapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public MovieResponse getMovie(@PathVariable Long id){
        return movieService.findById(id);
    }

    @GetMapping("/available")
    public List<MovieResponse> getAllAvailableMovies() {
        return movieService.getAllAvailableMovies();
    }
}
