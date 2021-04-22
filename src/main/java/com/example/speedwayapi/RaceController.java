package com.example.speedwayapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RaceController {

    RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }


    @PostMapping("raceevent")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRaceEvent(@RequestBody RaceDTO raceDTO){
        this.raceService.create(raceDTO);

    }

    @GetMapping("raceevent")
    public List<RaceDTO> getRaceEvent(){
        return this.raceService.fetchAll();
    }
}
