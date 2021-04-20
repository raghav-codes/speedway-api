package com.example.speedwayapi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaceCarController {

@Autowired
    private RaceCarService raceCarService;

    /*@GetMapping("race-cars")
    String getAllRaceCars(){

        return "{}";
    }*/

    @GetMapping("race-cars")
    public List<RaceCarDto> getAllRaceCars() {
        return raceCarService.getAllRaceCars();
    }


    @PostMapping("add-race-car")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRaceCar(@RequestBody RaceCarDto raceCarDto) throws Exception {
        raceCarService.addRaceCar(raceCarDto);
    }

}
