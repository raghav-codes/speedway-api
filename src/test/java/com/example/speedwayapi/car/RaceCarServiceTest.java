package com.example.speedwayapi.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class RaceCarServiceTest {


    @Mock
    RaceCarRepository repository;

    @InjectMocks
    RaceCarService raceCarService;

    @Test
    public void getAllRaceCarsTest(){
        List<RaceCarEntity> raceCarEntityList = new ArrayList<>();

        raceCarEntityList.add(new RaceCarEntity("The Condor","Corvette","2019","Raghav","AVAILABLE",185));

        when(repository.findAll()).thenReturn(List.of(new RaceCarEntity("The Condor","Corvette","2019","Raghav","AVAILABLE",185)));

        assertEquals(raceCarService.getAllRaceCars(),raceCarEntityList);
    }


    @Test
    public void addRaceCarTest() throws RaceCarExistException {
        var entity = new RaceCarEntity("The Condor","Corvette","2019","Raghav","AVAILABLE",185);

        when(repository.save(any())).thenReturn(entity);

        raceCarService.addRaceCar(new RaceCarDto("The Condor","Corvette","2019","Raghav","AVAILABLE",185));

        verify(repository).save(entity);
    }

}
