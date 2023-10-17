package com.softtech.go2climbwebapi.experience_design.infraestructure.persistence;

import com.softtech.go2climbwebapi.experience_design.domain.model.entities.Location;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILocationRepository extends R2dbcRepository<Location,Integer> {
    Mono<Location> findByName(String name);
}
