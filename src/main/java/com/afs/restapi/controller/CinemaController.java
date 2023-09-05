package com.afs.restapi.controller;

import com.afs.restapi.mappers.CinemaResponse;
import com.afs.restapi.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/locations/{locationId}/movies/{movieId}")
    public List<CinemaResponse> getAllCinemasByLocationAndMovie(
            @PathVariable Long locationId,
            @PathVariable Long movieId
    ) {
        return cinemaService.getCinemasByLocationAndMovie(locationId, movieId);
    }
}
