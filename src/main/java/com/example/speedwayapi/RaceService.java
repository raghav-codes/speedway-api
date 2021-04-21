package com.example.speedwayapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    @Autowired
    public RaceService (RaceRepository raceRepository){
        this.raceRepository=raceRepository;
    }
    public void create (RaceDTO raceDTO){
        raceRepository.save(
                new RaceEntity(raceDTO.getName(),raceDTO.getCategory(),
                        raceDTO.getDate(),raceDTO.getBestTime(),
                        raceDTO.getWinner(),raceDTO.getParticipants()));
    }
}
