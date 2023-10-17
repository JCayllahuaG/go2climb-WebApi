package com.softtech.go2climbwebapi.shared.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception{

    private final HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String Message){
        super(Message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus(){
        return this.httpStatus;
    }

}
