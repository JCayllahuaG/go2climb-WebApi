package com.softtech.go2climbwebapi.experience_design.interfaces.rest.handler;

import com.softtech.go2climbwebapi.experience_design.domain.service.IAgencyService;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.AgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.CreateAgencyResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency.UpdateAgencyResource;
import com.softtech.go2climbwebapi.shared.validation.ObjectValidator;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Agencies", description = "Create, read, update and delete agencies")
public class AgencyHandler {

    private final IAgencyService agencyService;
    private final ObjectValidator validator;


    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(agencyService.getAll(), AgencyResource.class);
    }

    public Mono<ServerResponse> getAgencyById(ServerRequest request){
        int id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(agencyService.getAgencyById(id), AgencyResource.class);
    }
    public Mono<ServerResponse> createAgency(ServerRequest request){
        Mono<CreateAgencyResource> dtoMono = request.bodyToMono(CreateAgencyResource.class)
                .doOnNext(validator::validate);

       return dtoMono.flatMap(agencyService::createAgency)
               .flatMap(agencyResource -> ServerResponse.ok()
                       .contentType(MediaType.APPLICATION_JSON)
                       .bodyValue(agencyResource));

    }
    public Mono<ServerResponse> updateAgency(ServerRequest request){
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<UpdateAgencyResource> dtoMono = request
                .bodyToMono(UpdateAgencyResource.class)
                .doOnNext(validator::validate);

        return dtoMono.flatMap(dto -> agencyService.updateAgency(id, dto))
                .flatMap(agencyResource -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(agencyResource));
    }
    public Mono<ServerResponse> deleteAgency(ServerRequest request){
        int id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(agencyService.deleteAgency(id), Void.class);
    }


}
