package com.afs.restapi.test;

import com.afs.restapi.entity.Movie;
import com.afs.restapi.exception.MovieNotFoundException;
import com.afs.restapi.mappers.movie.MovieResponse;
import com.afs.restapi.repository.MovieRepository;
import com.afs.restapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    @BeforeEach void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_return_movies_when_get_all_given_some_movies() {
        // Given
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie(1L, "Avengers", true, "https://example.com/avengers.jpg", "Description", 4.0, "Director", "Action", "https://example.com/landscape.jpg", new BigDecimal("400.00")));

        // When
        when(movieRepository.findAll()).thenReturn(allMovies);
        List<MovieResponse> movies = movieService.getAllMovies();

        // Then
        assertEquals(1, movies.size());
        assertEquals("Avengers", movies.get(0).getMovieTitle());
    }

    @Test
     void should_return_available_movies_when_get_available_movies_given_some_movies() {
        // Given
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie(1L, "Avengers", true, "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg", "something",5.0, "qwerty","qwerywr", "qwerty", new BigDecimal("400.00")));


        // When
        when(movieRepository.findAll()).thenReturn(allMovies);
        List<MovieResponse> result = movieService.getAllAvailableMovies();

        // Then
        assertEquals(1, result.size());
    }

    @Test
    void should_return_movie_when_get_movie_given_id(){
        Long id = 2L;
        Movie expectedResult = new Movie(2L, "Justice League", false, "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg", "something",4.6, "qwerty","qwerywr", "qwerty", new BigDecimal("400.00"));
        when(movieRepository.findById(id)).thenReturn(Optional.of(expectedResult));

        MovieResponse actualResult = movieService.findById(id);

        assertEquals(expectedResult.getId(), actualResult.getId());
        assertEquals(expectedResult.getMovieTitle(), actualResult.getMovieTitle());
    }

    @Test
    void should_return_movie_not_found_when_get_movie_given_invalid_id() {
    //given
        Long invalidId = 999L;

     //when
        MovieNotFoundException movieNotFoundException = assertThrows(MovieNotFoundException.class, () ->
                movieService.findById(invalidId));

     //then
        assertEquals("movie not found", movieNotFoundException.getMessage());
    }
}
