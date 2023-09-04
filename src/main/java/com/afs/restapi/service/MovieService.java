package com.afs.restapi.service;

import com.afs.restapi.entity.Movie;
import com.afs.restapi.mappers.MovieMapper;
import com.afs.restapi.mappers.MovieResponse;
import com.afs.restapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieResponse> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<MovieResponse> getMovieByTitle(String movieRequest){
        return movieRepository.findByMovieTitleContainingIgnoreCase(movieRequest)
                .stream()
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());

    }

    public List<MovieResponse> getAllAvailableMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> availableMovies = movies.stream()
                .filter(Movie::isAvailable)
                .collect(Collectors.toList());

        return availableMovies.stream()
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());
    }
}
