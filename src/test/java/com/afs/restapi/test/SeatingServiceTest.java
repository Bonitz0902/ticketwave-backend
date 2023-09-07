package com.afs.restapi.test;

import com.afs.restapi.entity.Seating;
import com.afs.restapi.exception.SeatingNotFoundException;
import com.afs.restapi.mappers.SeatingMapper;
import com.afs.restapi.mappers.SeatingRequest;
import com.afs.restapi.mappers.SeatingResponse;
import com.afs.restapi.repository.SeatingRepository;
import com.afs.restapi.service.SeatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SeatingServiceTest {

    @Mock
    private SeatingRepository seatingRepository;

    @Mock
    private SeatingMapper seatingMapper;

    private SeatingService seatingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        seatingService = new SeatingService(seatingRepository, seatingMapper);
    }

    @Test
    void should_create_seating() {
        // Arrange
        SeatingRequest request = new SeatingRequest(1L, Collections.singletonList("A1"), true);
        Seating seating = new Seating(1L, 1L, "A1", true);
        SeatingResponse response = new SeatingResponse(1L, 1L, "A1", true);

        when(seatingMapper.toEntity(request)).thenReturn(seating);
        when(seatingRepository.save(seating)).thenReturn(seating);
        when(seatingMapper.toResponse(seating)).thenReturn(response);

        // Act
        SeatingResponse createdSeating = seatingService.createSeating(request);

        // Assert
        assertThat(createdSeating).isNotNull();
    }

    @Test
    void should_return_seating_by_id() {
        // Arrange
        Long seatingId = 1L;
        Seating seating = new Seating(seatingId, 1L, "A1", true);
        SeatingResponse response = new SeatingResponse(seating.getSeatingId(), seating.getScheduleId(), seating.getSeatNumber(), seating.isAvailable());

        when(seatingRepository.findById(seatingId)).thenReturn(Optional.of(seating));
        when(seatingMapper.toResponse(seating)).thenReturn(response);

        // Act
        SeatingResponse foundSeating = seatingService.getSeatingById(seatingId);

        // Assert
        assertThat(foundSeating).isNotNull();
    }

    @Test
    public void testDeleteSeating() {
        Long seatingId = 1L;
        when(seatingRepository.findById(seatingId)).thenReturn(Optional.of(new Seating()));

        assertDoesNotThrow(() -> seatingService.deleteSeating(seatingId));
    }

    @Test
    public void testDeleteSeatingNotFound() {
        Long seatingId = 1L;
        when(seatingRepository.findById(seatingId)).thenReturn(Optional.empty());

        assertThrows(SeatingNotFoundException.class, () -> seatingService.deleteSeating(seatingId));
    }

    @Test
    public void should_update_seating() {
        // Arrange
        Long seatingId = 1L;
        SeatingRequest request = new SeatingRequest(1L, Collections.singletonList("A1"), true);
        Seating seating = new Seating(seatingId, 1L, "A1", true);
        SeatingResponse response = new SeatingResponse(seating.getSeatingId(), seating.getScheduleId(), seating.getSeatNumber(), seating.isAvailable());

        when(seatingRepository.findById(seatingId)).thenReturn(Optional.of(seating));
        when(seatingMapper.updateSeatingFromRequest(seating, request)).thenReturn(seating);
        when(seatingRepository.save(seating)).thenReturn(seating);
        when(seatingMapper.toResponse(seating)).thenReturn(response);

        // Act
        SeatingResponse updatedSeating = seatingService.updateSeating(seatingId, request);

        // Assert
        assertThat(updatedSeating).isNotNull();
    }

    @Test
    public void should_throw_seating_not_found_exception_when_updating() {
        // Arrange
        Long seatingId = 1L;
        SeatingRequest request = new SeatingRequest(1L, Collections.singletonList("A1"), true);

        when(seatingRepository.findById(seatingId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(SeatingNotFoundException.class, () -> seatingService.updateSeating(seatingId, request));
    }

    @Test
    void should_return_all_seatings() {
        // Arrange
        List<Seating> seatings = new ArrayList<>();
        seatings.add(new Seating(1L, 1L, "A1", true));
        seatings.add(new Seating(2L, 1L, "A2", true));

        List<SeatingResponse> expectedResponses = new ArrayList<>();
        expectedResponses.add(new SeatingResponse(1L, 1L, "A1", true));
        expectedResponses.add(new SeatingResponse(2L, 1L, "A2", true));

        when(seatingRepository.findAll()).thenReturn(seatings);
        when(seatingMapper.toResponseList(seatings)).thenReturn(expectedResponses);

        // Act
        List<SeatingResponse> allSeatings = seatingService.getAllSeatings();

        // Assert
        assertThat(allSeatings).isNotNull();
        assertThat(allSeatings).hasSize(2);
    }






}
