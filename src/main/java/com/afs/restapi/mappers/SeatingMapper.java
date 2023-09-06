package com.afs.restapi.mappers;

import com.afs.restapi.entity.Seating;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeatingMapper {

    public SeatingResponse toResponse(Seating seating) {
        SeatingResponse response = new SeatingResponse();
        BeanUtils.copyProperties(seating, response);
        return response;
    }

    public List<SeatingResponse> toResponseList(List<Seating> seatings) {
        return seatings.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Seating toEntity(SeatingRequest request) {
        Seating seating = new Seating();
        BeanUtils.copyProperties(request, seating);
        return seating;
    }

    public Seating updateSeatingFromRequest(Seating seating, SeatingRequest request) {
        BeanUtils.copyProperties(request, seating);
        return seating;
    }
}




