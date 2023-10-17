package com.softtech.go2climbwebapi.experience_design.infraestructure.mapping;

import com.softtech.go2climbwebapi.experience_design.domain.model.entities.Agency;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.AgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.CreateAgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.UpdateAgencyResource;
import com.softtech.go2climbwebapi.shared.mapping.EnhancedModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;


public class AgencyMapper implements Serializable {

    @Autowired
    public EnhancedModelMapper mapper;

    public AgencyResource toDto(Agency model){
        return mapper.map(model, AgencyResource.class);
    }

    public Agency toModel(AgencyResource agencyResource){
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return mapper.map(agencyResource, Agency.class);
    }
    public Agency toModel(CreateAgencyResource createAgencyResource){
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper.map(createAgencyResource, Agency.class);
    }
    public Agency toModel(UpdateAgencyResource updateAgencyResource){
        return mapper.map(updateAgencyResource, Agency.class);
    }

}
