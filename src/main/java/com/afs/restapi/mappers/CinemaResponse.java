package com.afs.restapi.mappers;

public class CinemaResponse {

    private Long cinemaId;
    private String locationName;
    private String movieTitle;
    private String cinemaName;

    public CinemaResponse() {
    }

    public CinemaResponse(Long cinemaId, Long locationId, Long movieId, String cinemaName, String locationName, String movieTitle) {
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
}
