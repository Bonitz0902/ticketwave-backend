package com.afs.restapi.test;

import com.afs.restapi.entity.Movie;
import com.afs.restapi.mappers.MovieResponse;
import com.afs.restapi.repository.MovieRepository;
import com.afs.restapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void should_return_movies_when_get_all_given_some_movies(){
        // Given
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie(1L, "Avengers", true));
        allMovies.add(new Movie(2L, "Justice League", false));
        allMovies.add(new Movie(3L, "Jumanji", true));
        // When
        when(movieRepository.findAll()).thenReturn(allMovies);
        List<MovieResponse> movies = movieService.getAllMovies();

        // Then
        assertEquals(3, movies.size());
        assertEquals("Avengers", movies.get(0).getMovieTitle());
        assertEquals("Justice League", movies.get(1).getMovieTitle());
        assertEquals("Jumanji", movies.get(2).getMovieTitle());
    }

    @Test
     void should_return_available_movies_when_get_available_movies_given_some_movies() {
        // Given
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie(1L, "Avengers", true));
        allMovies.add(new Movie(2L, "Justice League", false));
        allMovies.add(new Movie(3L, "Jumanji", true));

        // When
        when(movieRepository.findAll()).thenReturn(allMovies);
        List<MovieResponse> result = movieService.getAllAvailableMovies();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    void should_return_search_movies_when_search_movies_given_query(){
        String query = "Justice";
        List<Movie> expectedResult = new ArrayList<>();
        expectedResult.add(new Movie(2L, "Justice League", false));

        when(movieRepository.findByMovieTitleContainingIgnoreCase(query)).thenReturn(expectedResult);

        List<MovieResponse> actualResult = movieService.getMovieByTitle(query);

        assertThat(actualResult.get(0).getMovieTitle()).isEqualTo(expectedResult.get(0).getMovieTitle());


    }
}
