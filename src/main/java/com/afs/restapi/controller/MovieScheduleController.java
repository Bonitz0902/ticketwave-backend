package com.afs.restapi.controller;

import com.afs.restapi.mappers.movieschedule.MovieScheduleRequest;
import com.afs.restapi.mappers.movieschedule.MovieScheduleResponse;
import com.afs.restapi.service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie-schedules")
public class MovieScheduleController {
    private final MovieScheduleService movieScheduleService;

    @Autowired
    public MovieScheduleController(MovieScheduleService movieScheduleService) {
        this.movieScheduleService = movieScheduleService;
    }

    @PostMapping
    public ResponseEntity<MovieScheduleResponse> createMovieSchedule(@RequestBody MovieScheduleRequest request) {
        MovieScheduleResponse createdSchedule = movieScheduleService.createMovieSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchedule);
    }

    @GetMapping("/{scheduleId}")
    public MovieScheduleResponse getMovieSchedule(@PathVariable Long scheduleId) {
        return movieScheduleService.findById(scheduleId);
    }

    @GetMapping
    public ResponseEntity<List<MovieScheduleResponse>> getAllMovieSchedules() {
        List<MovieScheduleResponse> schedules = movieScheduleService.getAllMovieSchedules();
        return ResponseEntity.ok(schedules);
    }
}
