package com.softtech.go2climbwebapi.experience_design.interfaces.rest.handler;

import com.softtech.go2climbwebapi.experience_design.domain.service.ILocationService;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.CreateLocationResource;
import com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location.LocationResource;
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
@Tag(name = "Locations", description = "Create and read locations")
public class LocationHandler {
    private final ILocationService locationService;
    private final ObjectValidator validator;

    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(locationService.getAll(), LocationResource.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request){
        int id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(locationService.getById(id), LocationResource.class);
    }
    public Mono<ServerResponse> create(ServerRequest request){
        Mono<CreateLocationResource> dtoMono = request.bodyToMono(CreateLocationResource.class)
                .doOnNext(validator::validate);

        return dtoMono.flatMap(locationService::save)
                .flatMap(locationResource -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(locationResource));
    }
}
