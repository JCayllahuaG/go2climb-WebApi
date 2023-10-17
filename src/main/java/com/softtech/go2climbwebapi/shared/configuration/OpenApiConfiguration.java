package com.softtech.go2climbwebapi.shared.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI(
    ){
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Go2Climb REST API")
                        .version("1.0")
                        .description("Go2Climb REST API documentation")
                        .termsOfService("https://go2climb.com/tos")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                        )
                        .contact(
                                new Contact()
                                        .url("https://go2climb.com")
                                        .name("Go2Climb")
                        ));
    }
}
