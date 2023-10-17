package com.softtech.go2climbwebapi.experience_design.infraestructure.mapping;

import com.softtech.go2climbwebapi.experience_design.domain.model.entities.Location;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.CreateLocationResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.LocationResource;
import com.softtech.go2climbwebapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class LocationMapper implements Serializable {

    @Autowired
    public EnhancedModelMapper mapper;

    public LocationResource toDto(Location model){
        return mapper.map(model, LocationResource.class);
    }

    public Location toModel(LocationResource locationResource){
        return mapper.map(locationResource, Location.class);
    }
    public Location toModel(CreateLocationResource createLocationResource){
        return mapper.map(createLocationResource, Location.class);
    }

}
