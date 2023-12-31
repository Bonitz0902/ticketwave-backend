package com.afs.restapi.mappers.cinema;

public class CinemaResponse {

    private Long cinemaId;
    private String locationName;
    private String movieTitle;
    private String cinemaName;
    private Long locationId;
    private Long movieId;

    public CinemaResponse() {
    }

    public CinemaResponse(Long cinemaId, String cinemaName, String locationName, String movieTitle) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.locationName = locationName;
        this.movieTitle = movieTitle;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
