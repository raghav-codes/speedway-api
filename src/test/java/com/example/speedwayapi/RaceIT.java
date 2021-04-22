package com.example.speedwayapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs // New Annotation
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RaceIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addRaceEvent() throws Exception {

        LocalDate date1 = LocalDate.now();
        LocalTime time1 = LocalTime.now();
        RaceDTO raceDTO = new RaceDTO("Grand Prix III","stock car",date1,time1,"Gamma","Michael");

        LocalDate date2 = LocalDate.now();
        LocalTime time2 = LocalTime.now();
        RaceDTO raceDTO1 = new RaceDTO("Grand Prix 4","stock car",date2,time2,"Gamma","Michael");


        mockMvc.perform(post("/raceevent")
                .content("")
                .content(objectMapper.writeValueAsString(raceDTO))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated())
         .andDo(document("PostRaceEvent"));

        mockMvc.perform(post("/raceevent")
                .content("")
                .content(objectMapper.writeValueAsString(raceDTO1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/raceevent")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0].name").value("Grand Prix III"))
                .andExpect(jsonPath("[1].name").value("Grand Prix 4"))
                .andDo(document("GetRaceEvent", responseFields(
                        fieldWithPath("[0].name").description("Name of the event"),
                        fieldWithPath("[0].category").description("Category of the event"),
                        fieldWithPath("[0].date").description("Date of the event"),
                        fieldWithPath("[0].bestTime").description("Best time of the event"),
                        fieldWithPath("[0].winner").description("Winner of the event"),
                        fieldWithPath("[0].participants").description("Participants of the event")

                )));



    }
}
