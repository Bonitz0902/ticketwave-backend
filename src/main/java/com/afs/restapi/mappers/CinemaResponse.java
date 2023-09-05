package com.afs.restapi.mappers;

public class CinemaResponse {

    private Long id;
    private String cinemaName;
    private String locationName;

    public CinemaResponse() {
    }

    public CinemaResponse(Long id, String cinemaName, String locationName) {
        this.id = id;
        this.cinemaName = cinemaName;
        this.locationName = locationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
