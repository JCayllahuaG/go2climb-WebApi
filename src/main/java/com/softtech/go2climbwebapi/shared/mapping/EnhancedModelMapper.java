package com.softtech.go2climbwebapi.shared.mapping;

import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;



public class EnhancedModelMapper extends ModelMapper {
    public EnhancedModelMapper() {
        super();
    }

    public <S, T> Flux<T> mapFlux(Flux<S> sourceFlux, Class<T> targetClass) {
        return sourceFlux.map(fluxItem -> this.map(fluxItem, targetClass));
    }
}

