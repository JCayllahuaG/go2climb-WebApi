package com.softtech.go2climbwebapi.shared.configuration;

import com.softtech.go2climbwebapi.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper enhancedModelMapper(){
        return new EnhancedModelMapper();
    }
}
