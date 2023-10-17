package com.softtech.go2climbwebapi.experience_design.interfaces.router;

import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.CreateLocationResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.LocationResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.handler.LocationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
@Configuration
public class LocationRouter {
    private static final String LOCATION_BASE_PATH = "/locations";
    @RouterOperations({
            @RouterOperation(
                    path = LOCATION_BASE_PATH,
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.GET,
                    beanClass = LocationHandler.class,
                    beanMethod = "getAll",
                    operation = @Operation(
                            operationId = "getAllLocations",
                            summary = "Get all locations",
                            description = "Get all locations",
                            tags = {"Locations"},
                            responses = {
                                @ApiResponse(
                                        responseCode = "200",
                                        description = "Successful operation",
                                        content = @Content(
                                                schema = @Schema(
                                                        implementation = LocationResource.class))),
                            }
                    )
            ),
            @RouterOperation(
                    path = LOCATION_BASE_PATH + "/{id}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.GET,
                    beanClass = LocationHandler.class,
                    beanMethod = "getById",
                    operation = @Operation(
                            operationId = "getLocationById",
                            summary = "Get location by id",
                            description = "Get location by id",
                            tags = {"Locations"},
                            responses = {
                                @ApiResponse(
                                        responseCode = "200",
                                        description = "Successful operation",
                                        content = @Content(
                                                schema = @Schema(
                                                        implementation = LocationResource.class))),
                                @ApiResponse(
                                        responseCode = "404",
                                        description = "Location not found",
                                        content = @Content(
                                                schema = @Schema(
                                                        implementation = Exception.class)))
                            },
                            parameters =
                                    @Parameter(
                                            in = ParameterIn.PATH,
                                            name = "id"
                                    )
                    )

            ),
            @RouterOperation(
                    path = LOCATION_BASE_PATH,
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = LocationHandler.class,
                    beanMethod = "create",
                    operation = @Operation(
                            operationId = "createLocation",
                            summary = "Create location",
                            description = "Create location",
                            tags = {"Locations"},
                            responses = {
                                @ApiResponse(
                                        responseCode = "200",
                                        description = "Successful operation",
                                        content = @Content(
                                                schema = @Schema(
                                                        implementation = LocationResource.class))),
                                @ApiResponse(
                                        responseCode = "400",
                                        description = "Invalid input",
                                        content = @Content(
                                                schema = @Schema(
                                                        implementation = Exception.class)))
                            },
                            requestBody = @RequestBody(
                                    content = @Content(
                                            schema = @Schema(
                                                    implementation = CreateLocationResource.class))
                            )

                    )
            )
    })
    @Bean
    RouterFunction<ServerResponse> routerLocation(LocationHandler handler){
        return RouterFunctions.route()
                .GET(LOCATION_BASE_PATH, handler::getAll)
                .GET(LOCATION_BASE_PATH + "/{id}", handler::getById)
                .POST(LOCATION_BASE_PATH, handler::create)
                .build();

    }


}
