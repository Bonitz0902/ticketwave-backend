package com.afs.restapi.controller;

import com.afs.restapi.mappers.CinemaResponse;
import com.afs.restapi.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public List<CinemaResponse> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }
}
