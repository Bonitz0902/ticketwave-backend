package com.afs.restapi.test;

import com.afs.restapi.entity.Movie;
import com.afs.restapi.mappers.MovieResponse;
import com.afs.restapi.repository.MovieRepository;
import com.afs.restapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@SpringJUnitConfig
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    @BeforeEach void setUp(){
        List<Movie> mockMovies = new ArrayList<>();
        mockMovies.add(new Movie(1L,"Avengers"));
        mockMovies.add(new Movie(2L,"Justice League"));

        when(movieRepository.findAll()).thenReturn(mockMovies);
    }

    @Test
    void should_return_movies_when_get_all_given_some_movies(){
        // When
        List<MovieResponse> movies = movieService.getAllMovies();

        // Then
        assertEquals(2, movies.size());
        assertEquals("Avengers", movies.get(0).getMovieTitle());
        assertEquals("Justice League", movies.get(1).getMovieTitle());
    }
}
