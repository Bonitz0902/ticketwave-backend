package com.afs.restapi.test;

import com.afs.restapi.entity.Location;
import com.afs.restapi.mappers.LocationMapper;
import com.afs.restapi.mappers.LocationResponse;
import com.afs.restapi.repository.LocationRepository;
import com.afs.restapi.service.LocationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LocationServiceTest {

    @Test
    void should_return_all_locations() {
        // Given
        LocationRepository locationRepository = mock(LocationRepository.class);
        LocationMapper locationMapper = new LocationMapper();
        LocationService locationService = new LocationService(locationRepository, locationMapper);

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
