package com.afs.restapi.mappers;

public class MovieResponse {

    private Long id;
    private String movieTitle;

    public MovieResponse(){
    }

    public MovieResponse(Long id, String movieTitle) {
        this.id = id;
        this.movieTitle = movieTitle;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
