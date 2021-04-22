package com.example.speedwayapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)

public class RaceServiceTest {
    @Mock
    RaceRepository raceRepository;

    @InjectMocks
    RaceService subject;

    @Test
    void create() {

        LocalDate date1 = LocalDate.now();
        LocalTime time1 = LocalTime.now();
        RaceDTO raceDTO = new RaceDTO("Grand Prix III","stock car",date1,time1,"Gamma","Michael");

        subject.create(raceDTO);
        verify(raceRepository).save(
                new RaceEntity("Grand Prix III","stock car",date1,time1,"Gamma","Michael")
        );
    }
}
