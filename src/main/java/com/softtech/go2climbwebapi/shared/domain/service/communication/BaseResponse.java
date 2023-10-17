package com.softtech.go2climbwebapi.shared.domain.service.communication;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
public abstract class BaseResponse<T> {
    private final boolean success;
    private final String message;
    private final T resource;


    public BaseResponse(String message) {
        this.success = false;
        this.message = message;
        this.resource = null;
    }

    public BaseResponse(T resource) {
        this.success = true;
        this.message = Strings.EMPTY;
        this.resource = resource;
    }

}
