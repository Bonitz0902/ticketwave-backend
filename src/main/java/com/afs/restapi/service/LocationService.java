package com.afs.restapi.service;

import com.afs.restapi.entity.Location;
import com.afs.restapi.mappers.location.LocationMapper;
import com.afs.restapi.mappers.location.LocationResponse;
import com.afs.restapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    public List<LocationResponse> getAllLocations() {
        List<Location> locations = locationRepository.findAll();

        return locations.stream()
                .map(locationMapper::toResponse)
                .collect(Collectors.toList());
    }
}
