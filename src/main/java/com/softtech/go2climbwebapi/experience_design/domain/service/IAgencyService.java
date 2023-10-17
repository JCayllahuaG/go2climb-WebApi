package com.softtech.go2climbwebapi.experience_design.domain.service;

import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.AgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.CreateAgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.UpdateAgencyResource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAgencyService {

    Mono<AgencyResource> getAgencyById(Integer agencyId);
    Flux<AgencyResource> getAll();
    Mono<AgencyResource> createAgency(CreateAgencyResource agencyDto);
    Mono<AgencyResource> updateAgency(Integer agencyId, UpdateAgencyResource agencyDto);
    Mono<Void> deleteAgency(Integer agencyId);

}
