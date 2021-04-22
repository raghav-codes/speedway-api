package com.example.speedwayapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<RaceDTO> fetchAll() {

        return raceRepository.findAll()
                .stream()
                .map(raceEntity -> {
                    return new RaceDTO(raceEntity.getName(),
                            raceEntity.getCategory(),
                            raceEntity.getDate(),
                            raceEntity.getBestTime(),
                            raceEntity.getWinner(),
                            raceEntity.getParticipants()
                    );
                })
                .collect(Collectors.toList());

    }
}
