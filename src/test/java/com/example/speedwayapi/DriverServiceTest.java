package com.example.speedwayapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class DriverServiceTest {

    @Mock
    DriverRepository driverRepos;

    @InjectMocks
    DriverService subject;

    @Test
    void create() {


        DriverDto driverSerObj = new DriverDto("Maria", "Lopez", 22, "Nickname1", 1, 5);
        subject.create(driverSerObj);
        verify(driverRepos).save(
                new DriverEntity("Maria", "Lopez", 22, "Nickname1", 1, 5)
        );
    }
}
