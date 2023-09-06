package com.afs.restapi.exception;

public class SeatingNotFoundException extends RuntimeException {

    public SeatingNotFoundException(Long seatingId) {
        super("Seating not found with ID: " + seatingId);
    }
}
