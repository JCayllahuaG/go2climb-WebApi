package com.softtech.go2climbwebapi.experience_design.application.internal.commandservices;

import com.softtech.go2climbwebapi.experience_design.domain.model.entities.Agency;
import com.softtech.go2climbwebapi.experience_design.domain.service.IAgencyService;
import com.softtech.go2climbwebapi.experience_design.infraestructure.mapping.AgencyMapper;
import com.softtech.go2climbwebapi.experience_design.infraestructure.persistence.IAgencyRepository;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.AgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.CreateAgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.UpdateAgencyResource;
import com.softtech.go2climbwebapi.shared.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements IAgencyService {

    private final IAgencyRepository agencyRepository;
    @Autowired
    private AgencyMapper agencyMapper;

    @Override
    public Mono<AgencyResource> getAgencyById(Integer agencyId) {

       return agencyRepository.findById(agencyId)
               .map(agencyMapper::toDto).switchIfEmpty(Mono.error(new Exception("Agency not found")));
    }

    @Override
    public Flux<AgencyResource> getAll() {
        return agencyRepository.findAll()
                .map(agencyMapper::toDto);
    }
    @Override
    public Mono<AgencyResource> createAgency(CreateAgencyResource createAgencyResource) {

        Mono<Boolean> existAgencyName = agencyRepository.findByName(createAgencyResource.getName()).hasElement();

        return existAgencyName.flatMap(exists -> exists ? Mono.error(new Exception("Agency name already exists"))
                : agencyRepository.save(agencyMapper.toModel(createAgencyResource)).map(agencyMapper::toDto));

    }

    @Override
    public Mono<AgencyResource> updateAgency(Integer agencyId, UpdateAgencyResource updateAgencyResource) {

        Mono<Boolean> existAgency = agencyRepository.findById(agencyId).hasElement();


        Mono<Agency> agencyRepeatedName = agencyRepository.findByName(updateAgencyResource.getName());


        return existAgency.flatMap(
                exists -> exists
                        ? agencyRepeatedName.flatMap(
                                repeatedName -> repeatedName !=null && repeatedName.getId().equals(agencyId)
                                        ? agencyRepository.save(agencyMapper.toModel(updateAgencyResource)).map(agencyMapper::toDto)
                                        : Mono.error(new CustomException(HttpStatus.BAD_REQUEST,"Agency name already exists"))
                        )
                        : Mono.error(new CustomException(HttpStatus.BAD_REQUEST,"Agency not found"))
        );

    }

    @Override
    public Mono<Void> deleteAgency(Integer agencyId) {
        Mono<Boolean> existAgency = agencyRepository.findById(agencyId).hasElement();
        return existAgency.flatMap(exists -> exists ? agencyRepository.deleteById(agencyId) : Mono.error(new Exception("Agency not found")));


    }
}
