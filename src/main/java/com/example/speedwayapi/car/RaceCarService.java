package com.example.speedwayapi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<RaceCarEntity> getAllRaceCars() {
        return raceCarRepository.findAll();
    }

    public void addRaceCar(RaceCarDto raceCarDto) throws RaceCarExistException{
        Optional<RaceCarEntity> memberExists = raceCarRepository.findAll()
                .stream()
                .filter(raceCarEntity -> raceCarEntity.getNickname().equals(raceCarDto.getNickname()))
                .findAny();

        if (memberExists.isPresent()) {

            throw new RaceCarExistException();

        } else {
            raceCarRepository.save(new RaceCarEntity(
                    raceCarDto.getNickname(),
                    raceCarDto.getModel(),
                    raceCarDto.getYear(),
                    raceCarDto.getOwner(),
                    raceCarDto.getStatus(),
                    raceCarDto.getTop_speed()
            ));
        }
    }

}
