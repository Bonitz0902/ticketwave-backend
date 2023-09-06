package com.afs.restapi.exception;

public class MovieScheduleNotFoundException extends RuntimeException {
    public MovieScheduleNotFoundException(Long scheduleId) {
        super("Movie schedule not found with ID: " + scheduleId);
    }
}
