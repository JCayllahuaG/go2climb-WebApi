package com.softtech.go2climbwebapi.experience_design.application.services;

import com.softtech.go2climbwebapi.experience_design.domain.model.entities.Location;
import com.softtech.go2climbwebapi.experience_design.domain.service.ILocationService;
import com.softtech.go2climbwebapi.experience_design.infraestructure.mapping.LocationMapper;
import com.softtech.go2climbwebapi.experience_design.infraestructure.persistence.ILocationRepository;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.CreateLocationResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.LocationResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements ILocationService {

    private final ILocationRepository locationRepository;
    @Autowired
    private LocationMapper locationMapper;

    @Override
    public Mono<LocationResource> getById(Integer id) {
        return locationRepository.findById(id)
                .map(locationMapper::toDto).switchIfEmpty(Mono.error(new Exception("Location not found")));
    }

    @Override
    public Flux<LocationResource> getAll() {
        return locationRepository.findAll()
                .map(locationMapper::toDto);
    }

    @Override
    public Mono<LocationResource> save(CreateLocationResource location) {

        Mono<Boolean> existLocationName = locationRepository.findByName(location.getName()).hasElement();

        return existLocationName.flatMap(exists -> exists ? Mono.error(new Exception("Location name already exists"))
                : locationRepository.save(locationMapper.toModel(location)).map(locationMapper::toDto));

    }
}
