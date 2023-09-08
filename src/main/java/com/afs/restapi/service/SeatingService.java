package com.afs.restapi.service;

import com.afs.restapi.entity.Seating;
import com.afs.restapi.exception.SeatingNotFoundException;
import com.afs.restapi.mappers.SeatingMapper;
import com.afs.restapi.mappers.SeatingRequest;
import com.afs.restapi.mappers.SeatingResponse;
import com.afs.restapi.repository.SeatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingService {

    private final SeatingRepository seatingRepository;
    private final SeatingMapper seatingMapper;

    @Autowired
    public SeatingService(SeatingRepository seatingRepository, SeatingMapper seatingMapper) {
        this.seatingRepository = seatingRepository;
        this.seatingMapper = seatingMapper;
    }

    public SeatingResponse createSeating(SeatingRequest request) {
        Seating seating = seatingMapper.toEntity(request);
        seating = seatingRepository.save(seating);
        return seatingMapper.toResponse(seating);
    }

    public SeatingResponse updateSeating(Long seatingId, SeatingRequest request) {
        Seating existingSeating = seatingRepository.findById(seatingId)
                .orElseThrow(() -> new SeatingNotFoundException(seatingId));

        seatingMapper.updateSeatingFromRequest(existingSeating, request);
        existingSeating = seatingRepository.save(existingSeating);
        return seatingMapper.toResponse(existingSeating);
    }

    public void deleteSeating(Long seatingId) {
        seatingRepository.findById(seatingId).orElseThrow(() -> new SeatingNotFoundException(seatingId));
        seatingRepository.deleteById(seatingId);
    }

    public SeatingResponse getSeatingById(Long seatingId) {
        Seating seating = seatingRepository.findById(seatingId)
                .orElseThrow(() -> new SeatingNotFoundException(seatingId));
        return seatingMapper.toResponse(seating);
    }

    public List<SeatingResponse> getAllSeatings() {
        List<Seating> seatings = seatingRepository.findAll();
        return seatingMapper.toResponseList(seatings);
    }

    public List<SeatingResponse> bookMultipleSeats(List<Long> seatingIds) {
        List<Seating> seatings = seatingRepository.findAllByIdIn(seatingIds);
        seatings.forEach(seating -> seating.setAvailable(false));
        seatings = seatingRepository.saveAll(seatings);
        return seatingMapper.toResponseList(seatings);
    }

    public boolean areSeatsAvailable(List<Long> seatingIds) {
        Long count = seatingRepository.countAllByIsAvailableTrueAndSeatingIdIn(seatingIds);
        return count != null && count.equals((long) seatingIds.size());
    }
}


