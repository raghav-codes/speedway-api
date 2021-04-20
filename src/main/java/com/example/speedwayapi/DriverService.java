package com.example.speedwayapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
