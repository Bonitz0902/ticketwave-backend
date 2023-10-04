package com.afs.restapi.mappers.movie;

import com.afs.restapi.entity.Movie;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    private MovieMapper() {
        //empty Constructor
    }

    public static Movie toEntity(MovieRequest movieRequest) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieRequest, movie);
        return movie;
    }

    public MovieResponse toResponse(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        BeanUtils.copyProperties(movie, movieResponse);
        return movieResponse;
    }
}
