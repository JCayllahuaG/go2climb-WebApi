package com.softtech.go2climbwebapi.experience_design.infraestructure.persistence;

import com.softtech.go2climbwebapi.experience_design.domain.model.entities.Agency;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IAgencyRepository extends R2dbcRepository<Agency,Integer> {

    Mono<Agency> findByName(String name);
}
