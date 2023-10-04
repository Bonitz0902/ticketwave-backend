package com.afs.restapi.mappers.location;

public class LocationResponse {

    private Long locationId;
    private String locationName;

    public LocationResponse(){
        //Empty constructor
    }

    public LocationResponse(Long locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
