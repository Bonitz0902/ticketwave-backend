package com.afs.restapi.controller;

import com.afs.restapi.mappers.LocationResponse;
import com.afs.restapi.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationResponse> getAllLocations() {
        return locationService.getAllLocations();
    }
}
