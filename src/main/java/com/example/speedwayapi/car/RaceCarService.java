package com.example.speedwayapi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceCarService {

    @Autowired
    private RaceCarRepository raceCarRepository;

    String nickname;
    String model;
    String year;
    String owner;
    String status;
    long top_speed;

    public List<RaceCarDto> getAllRaceCars() {
        return raceCarRepository.findAll()
                .stream()
                .map(raceCarEntity -> {
                    return new RaceCarDto(
                            raceCarEntity.getNickname(),
                            raceCarEntity.getModel(),
                            raceCarEntity.getYear(),
                            raceCarEntity.getOwner(),
                            raceCarEntity.getStatus(),
                            raceCarEntity.getTop_speed()
                    );
                })
                .collect(Collectors.toList());
    }

}
