package com.afs.restapi.mappers.movieschedule;

import com.afs.restapi.entity.MovieSchedule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MovieScheduleMapper {
    public MovieScheduleResponse toResponse(MovieSchedule schedule) {
        MovieScheduleResponse response = new MovieScheduleResponse();
        BeanUtils.copyProperties(schedule, response);
        return response;
    }

    public MovieSchedule toEntity(MovieScheduleRequest request) {
        MovieSchedule schedule = new MovieSchedule();
        BeanUtils.copyProperties(request, schedule);
        return schedule;
    }
}
