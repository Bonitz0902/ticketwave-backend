package com.afs.restapi.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException() {
        super("movie not found");
    }
}
