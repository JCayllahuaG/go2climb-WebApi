package com.softtech.go2climbwebapi.experience_design.infraestructure.configuration;

import com.softtech.go2climbwebapi.experience_design.infraestructure.mapping.AgencyMapper;
import com.softtech.go2climbwebapi.experience_design.infraestructure.mapping.LocationMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("experienceDesignMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AgencyMapper agencyMapper(){
        return new AgencyMapper();
    }

    @Bean
    public LocationMapper locationMapper(){
        return new LocationMapper();
    }
}
