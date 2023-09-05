package com.afs.restapi.mappers;

import com.afs.restapi.entity.Cinema;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CinemaMapper {

    public CinemaResponse toResponse(Cinema cinema) {
        CinemaResponse cinemaResponse = new CinemaResponse();
        BeanUtils.copyProperties(cinema, cinemaResponse);
        return cinemaResponse;
    }
}