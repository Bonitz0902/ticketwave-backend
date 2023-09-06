package com.afs.restapi.service;

import com.afs.restapi.entity.MovieSchedule;
import com.afs.restapi.exception.MovieScheduleNotFoundException;
import com.afs.restapi.mappers.movieSchedule.MovieScheduleMapper;
import com.afs.restapi.mappers.movieSchedule.MovieScheduleRequest;
import com.afs.restapi.mappers.movieSchedule.MovieScheduleResponse;
import com.afs.restapi.repository.MovieScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieScheduleService {
    private final MovieScheduleRepository movieScheduleRepository;
    private final MovieScheduleMapper movieScheduleMapper;

    @Autowired
    public MovieScheduleService(MovieScheduleRepository movieScheduleRepository, MovieScheduleMapper movieScheduleMapper) {
        this.movieScheduleRepository = movieScheduleRepository;
        this.movieScheduleMapper = movieScheduleMapper;
    }

    public MovieScheduleResponse createMovieSchedule(MovieScheduleRequest request) {
        MovieSchedule schedule = movieScheduleMapper.toEntity(request);
        MovieSchedule savedSchedule = movieScheduleRepository.save(schedule);
        return movieScheduleMapper.toResponse(savedSchedule);
    }

    public MovieScheduleResponse findById(Long scheduleId) {
        MovieSchedule schedule = movieScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new MovieScheduleNotFoundException(scheduleId));
        return movieScheduleMapper.toResponse(schedule);
    }


    public List<MovieScheduleResponse> getAllMovieSchedules() {
        List<MovieSchedule> schedules = movieScheduleRepository.findAll();
        return schedules.stream()
                .map(movieScheduleMapper::toResponse)
                .collect(Collectors.toList());
    }
}
