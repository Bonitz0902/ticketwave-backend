package com.afs.restapi.test;

import com.afs.restapi.entity.Location;
import com.afs.restapi.mappers.location.LocationMapper;
import com.afs.restapi.mappers.location.LocationResponse;
import com.afs.restapi.repository.LocationRepository;
import com.afs.restapi.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    private LocationService locationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        LocationMapper locationMapper = new LocationMapper();
        locationService = new LocationService(locationRepository, locationMapper);
    }

    @Test
    void should_return_all_locations() {
        // Given
        List<Location> allLocations = new ArrayList<>();
        allLocations.add(new Location(1L, "Location A"));
        allLocations.add(new Location(2L, "Location B"));

        // When
        when(locationRepository.findAll()).thenReturn(allLocations);
        List<LocationResponse> locations = locationService.getAllLocations();

        // Then
        assertThat(locations.size()).isEqualTo(2);
        assertThat(locations.get(0).getLocationName()).isEqualTo("Location A");
        assertThat(locations.get(1).getLocationName()).isEqualTo("Location B");
    }
}
