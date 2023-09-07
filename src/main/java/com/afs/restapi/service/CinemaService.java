package com.afs.restapi.service;

import com.afs.restapi.entity.Cinema;
import com.afs.restapi.entity.Location;
import com.afs.restapi.entity.Movie;
import com.afs.restapi.mappers.cinema.CinemaMapper;
import com.afs.restapi.mappers.cinema.CinemaResponse;
import com.afs.restapi.repository.CinemaRepository;
import com.afs.restapi.repository.LocationRepository;
import com.afs.restapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;
    private final LocationRepository locationRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public CinemaService(
            CinemaRepository cinemaRepository,
            CinemaMapper cinemaMapper,
            LocationRepository locationRepository,
            MovieRepository movieRepository
    ) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaMapper = cinemaMapper;
        this.locationRepository = locationRepository;
        this.movieRepository = movieRepository;
    }

    public List<CinemaResponse> getCinemasByLocationAndMovie(Long locationId, Long movieId) {
        List<Cinema> cinemas = cinemaRepository.findAllByLocationLocationIdAndMovieId(locationId, movieId);

        return cinemas.stream()
                .map(cinema -> {
                    CinemaResponse cinemaResponse = cinemaMapper.toResponse(cinema);
                    cinemaResponse.setLocationName(getLocationNameById(locationId));
                    cinemaResponse.setMovieTitle(getMovieTitleById(movieId));
                    return cinemaResponse;
                })
                .collect(Collectors.toList());
    }

    private String getLocationNameById(Long locationId) {
        Location location = locationRepository.findById(locationId).orElse(null);
        return (location != null) ? location.getLocationName() : null;
    }

    private String getMovieTitleById(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        return (movie != null) ? movie.getMovieTitle() : null;
    }

    public List<CinemaResponse> getAllCinemas() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        return cinemas.stream()
                .map(cinema -> {
                    CinemaResponse cinemaResponse = cinemaMapper.toResponse(cinema);
                    cinemaResponse.setLocationName(getLocationNameById(cinema.getLocation().getLocationId()));
                    cinemaResponse.setMovieTitle(getMovieTitleById(cinema.getMovie().getId()));
                    cinemaResponse.setLocationId(cinema.getLocation().getLocationId()); // Set locationId
                    cinemaResponse.setMovieId(cinema.getMovie().getId()); // Set movieId
                    return cinemaResponse;
                })
                .collect(Collectors.toList());
    }

}
