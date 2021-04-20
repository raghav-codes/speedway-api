package com.example.speedwayapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DriverController {

    @PostMapping("driver")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDriver(){

    }

    @GetMapping("driver")
    public String getDrivers(){return "[{}]"; }
}
