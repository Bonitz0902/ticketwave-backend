package com.afs.restapi.mappers.location;

import com.afs.restapi.entity.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationMapper(){
        //empty Constructor
    }

    public LocationResponse toResponse(Location location) {
        LocationResponse locationResponse = new LocationResponse();
        BeanUtils.copyProperties(location, locationResponse);
        return locationResponse;
    }
}
