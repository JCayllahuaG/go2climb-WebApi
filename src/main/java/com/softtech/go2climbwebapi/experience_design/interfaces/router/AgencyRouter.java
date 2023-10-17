package com.softtech.go2climbwebapi.experience_design.interfaces.router;


import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.AgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.CreateAgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.UpdateAgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.handler.AgencyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
public class AgencyRouter {
    private static final String AGENCY_BASE_PATH = "/agencies";

    @RouterOperations({
            @RouterOperation(
                    path = AGENCY_BASE_PATH,
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.GET,
                    beanClass = AgencyHandler.class,
                    beanMethod = "getAll",
                    operation = @Operation(
                            operationId = "getAllAgencies",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Successful operation",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                            }
                    )),
            @RouterOperation(
                    path = AGENCY_BASE_PATH + "/{id}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.GET,
                    beanClass = AgencyHandler.class,
                    beanMethod = "getAgencyById",
                    operation = @Operation(
                            operationId = "getAgencyById",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Successful operation",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "Agency not found",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                                    @ApiResponse(
                                            responseCode = "500",
                                            description = "Agency not found ",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                            },
                            parameters = {
                                    @Parameter(
                                            in = ParameterIn.PATH,
                                            name = "id"
                                    )
                            }
                    )
            ),
            @RouterOperation(
                    path = AGENCY_BASE_PATH,
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = AgencyHandler.class,
                    beanMethod = "createAgency",
                    operation = @Operation(
                            operationId = "createAgency",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "201",
                                            description = "Successful operation",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                                    @ApiResponse(
                                            responseCode = "400",
                                            description = "Bad request",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class)))
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = CreateAgencyResource.class))
                            )
                    )
            ),
            @RouterOperation(
                    path = AGENCY_BASE_PATH + "/{id}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.PUT,
                    beanClass = AgencyHandler.class,
                    beanMethod = "updateAgency",
                    operation = @Operation(
                            operationId = "updateAgency",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Successful operation",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                                    @ApiResponse(
                                            responseCode = "400",
                                            description = "Bad request",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "Agency not found",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class)))
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = UpdateAgencyResource.class))
                            ),
                            parameters = {
                                    @Parameter(
                                            in = ParameterIn.PATH,
                                            name = "id"
                                    )
                            }
                    )

            ),
            @RouterOperation(
                    path = AGENCY_BASE_PATH + "/{id}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.DELETE,
                    beanClass = AgencyHandler.class,
                    beanMethod = "deleteAgency",
                    operation = @Operation(
                            operationId = "deleteAgency",
                            summary = "Delete agency",
                            description = "Delete agency",
                            tags = {"Agencies"},
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Successful operation",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class))),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "Agency not found",
                                            content = @Content(schema = @Schema(
                                                    implementation = AgencyResource.class)))
                            },
                            parameters = {
                                    @Parameter(
                                            in = ParameterIn.PATH,
                                            name = "id"
                                    )
                            }
                    )
            )




    })
    @Bean
    RouterFunction<ServerResponse> routerAgency(AgencyHandler handler){

        return RouterFunctions.route()
                .GET(AGENCY_BASE_PATH, handler::getAll)
                .GET(AGENCY_BASE_PATH + "/{id}", handler::getAgencyById)
                .POST(AGENCY_BASE_PATH, handler::createAgency)
                .PUT(AGENCY_BASE_PATH + "/{id}", handler::updateAgency)
                .DELETE(AGENCY_BASE_PATH + "/{id}", handler::deleteAgency)
                .build();
    }
}
