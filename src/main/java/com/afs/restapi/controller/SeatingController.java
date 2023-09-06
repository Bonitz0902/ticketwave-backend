package com.afs.restapi.controller;

import com.afs.restapi.mappers.SeatingRequest;
import com.afs.restapi.mappers.SeatingResponse;
import com.afs.restapi.service.SeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seating")
public class SeatingController {
    private final SeatingService seatingService;

    @Autowired
    public SeatingController(SeatingService seatingService) {
        this.seatingService = seatingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatingResponse> getSeatingById(@PathVariable Long id) {
        SeatingResponse seating = seatingService.getSeatingById(id);
        return ResponseEntity.ok(seating);
    }

    @GetMapping
    public ResponseEntity<List<SeatingResponse>> getAllSeatings() {
        List<SeatingResponse> seatings = seatingService.getAllSeatings();
        return ResponseEntity.ok(seatings);
    }

    @PostMapping
    public ResponseEntity<SeatingResponse> createSeating(@RequestBody SeatingRequest request) {
        SeatingResponse createdSeating = seatingService.createSeating(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeating);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatingResponse> updateSeating(
            @PathVariable Long id,
            @RequestBody SeatingRequest request
    ) {
        SeatingResponse updatedSeating = seatingService.updateSeating(id, request);
        return ResponseEntity.ok(updatedSeating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeating(@PathVariable Long id) {
        seatingService.deleteSeating(id);
        return ResponseEntity.noContent().build();
    }
}
