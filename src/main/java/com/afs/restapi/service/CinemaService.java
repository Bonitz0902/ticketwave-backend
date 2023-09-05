package com.afs.restapi.service;

import com.afs.restapi.entity.Cinema;
import com.afs.restapi.mappers.CinemaMapper;
import com.afs.restapi.mappers.CinemaResponse;
import com.afs.restapi.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository, CinemaMapper cinemaMapper) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaMapper = cinemaMapper;
    }

    public List<CinemaResponse> getAllCinemas() {
        List<Cinema> cinemas = cinemaRepository.findAll();

        return cinemas.stream()
                .map(cinemaMapper::toResponse)
                .collect(Collectors.toList());
    }

}
