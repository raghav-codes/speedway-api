package com.example.speedwayapi;

import com.example.speedwayapi.car.RaceCarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class DriverService {

    private final DriverRepository driverReposit;

    @Autowired
    public DriverService (DriverRepository driverReposit){
        this.driverReposit=driverReposit;
    }
    public void create (DriverDto driverObj){
        driverReposit.save(
                new DriverEntity(driverObj.getFirstName(),driverObj.getLastName(),
                        driverObj.getAge(),driverObj.getNickName(),
                        driverObj.getWins(),driverObj.getLoss()));
    }


    /*public void addDriverWithCars (List<RaceCarEntity> cars){
        driverReposit.save(
                new DriverEntity(driverObj.getFirstName(),driverObj.getLastName(),
                        driverObj.getAge(),driverObj.getNickName(),
                        driverObj.getWins(),driverObj.getLoss()));
    }*/

    public List<DriverDto> fetchAll() {

        return driverReposit.findAll()
                .stream()
                .map(driverEntityObj -> {
                    return new DriverDto(driverEntityObj.getFirstName(),
                            driverEntityObj.getLastName(),
                            driverEntityObj.getAge(),
                            driverEntityObj.getNickName(),
                            driverEntityObj.getWins(),
                            driverEntityObj.getLoss()
                            );
                })
                .collect(Collectors.toList());

    }
}
