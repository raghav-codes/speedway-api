package com.example.speedwayapi.car;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RaceCarControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void initialEmptyGetTest() throws Exception{

        mockMvc.perform(get("/race-cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0))
                .andDo(print());

    }


    @Test
    void postRaceCarTest() throws Exception{
        RaceCarDto input1 = new RaceCarDto("The Condor","Corvette","2019","Iqbal","AVAILABLE",189);
        mockMvc.perform(
                post("/add-race-car")
                        .content(objectMapper.writeValueAsString(input1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());
    }

    @Test
    void getMultipleRaceCarsTest() throws Exception{

        RaceCarDto input1 = new RaceCarDto("The Condor","Corvette","2019","Iqbal","AVAILABLE",189);
        mockMvc.perform(
                post("/add-race-car")
                        .content(objectMapper.writeValueAsString(input1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());

        RaceCarDto input2 = new RaceCarDto("Blue Fire","Ferrari","2017","Raghav","AVAILABLE",289);
        mockMvc.perform(
                post("/add-race-car")
                        .content(objectMapper.writeValueAsString(input2))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());

        mockMvc.perform(get("/race-cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andDo(print());

    }

    @Test // Post Conflict
    void postConflictTest() throws Exception{

        RaceCarDto input1 = new RaceCarDto("The Condor","Corvette","2019","Iqbal","AVAILABLE",189);

        //RaceCarDto input2 = new RaceCarDto("Blue Fire","Ferrari","2017","Raghav","AVAILABLE",289);
        mockMvc.perform(
                post("/add-race-car")
                        .content(objectMapper.writeValueAsString(input1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());


        mockMvc.perform(
                post("/add-race-car")
                        .content(objectMapper.writeValueAsString(input1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isConflict());

    }


}
