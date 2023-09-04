package com.afs.restapi.service;

import com.afs.restapi.entity.Movie;
import com.afs.restapi.mappers.MovieMapper;
import com.afs.restapi.mappers.MovieResponse;
import com.afs.restapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieResponse> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponse> movieResponses = movies.stream()
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());
        return movieResponses;
    }
}
