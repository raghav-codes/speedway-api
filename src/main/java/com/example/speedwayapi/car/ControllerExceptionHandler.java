package com.example.speedwayapi.car;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(RaceCarExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleRaceCarExistException() {
    }
}
