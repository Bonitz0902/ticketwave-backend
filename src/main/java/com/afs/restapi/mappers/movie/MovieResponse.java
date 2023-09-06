package com.afs.restapi.mappers.movie;

public class MovieResponse {

    private Long id;
    private String movieTitle;
    private String imageUrl;
    private String description;
    private Double rating;
    private String director;
    private String genre;
    private String imageUrlLandscape;

    public MovieResponse(){
    }

    public MovieResponse(Long id, String movieTitle, String imageUrl, String description, Double rating, String director, String genre, String imageUrlLandscape) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.imageUrl = imageUrl;
        this.description = description;
        this.rating = rating;
        this.director = director;
        this.genre = genre;
        this.imageUrlLandscape = imageUrlLandscape;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrlLandscape() {
        return imageUrlLandscape;
    }

    public void setImageUrlLandscape(String imageUrlLandscape) {
        this.imageUrlLandscape = imageUrlLandscape;
    }
}
