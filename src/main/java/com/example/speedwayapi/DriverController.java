package com.example.speedwayapi;

import com.example.speedwayapi.car.RaceCarEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DriverController {

    DriverService driverServ;

    public DriverController(DriverService driverServ) {
        this.driverServ = driverServ;
    }

    @PostMapping("driver")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDriver(@RequestBody DriverDto driverDtoObject){
        this.driverServ.create(driverDtoObject);

    }

    @GetMapping("driver")
    public List<DriverDto> getDrivers()
    {
               return this.driverServ.fetchAll();
    }



}
