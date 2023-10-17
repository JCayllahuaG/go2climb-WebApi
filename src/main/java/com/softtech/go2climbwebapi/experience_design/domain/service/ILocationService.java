package com.softtech.go2climbwebapi.experience_design.domain.service;

import com.softtech.go2climbwebapi.experience_design.domain.model.entities.Location;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.CreateLocationResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.LocationResource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILocationService {

    Mono<LocationResource> getById(Integer id);
    Flux<LocationResource> getAll();

    Mono<LocationResource> save(CreateLocationResource location);
}
