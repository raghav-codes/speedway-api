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

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs // New Annotation
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class DriverIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addDriver() throws Exception {

        DriverDto driverObj = new DriverDto("Maria","Lopez",22,"Nickname1",1,5);
        DriverDto driverObj2 = new DriverDto("Naria","Lopez",23,"Nickname2",2,5);
        DriverDto driverObj3 = new DriverDto("Oaria","Lopez",24,"Nickname3",3,5);

        mockMvc.perform(post("/driver")
                .content(objectMapper.writeValueAsString(driverObj))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(post("/driver")
                .content(objectMapper.writeValueAsString(driverObj2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(post("/driver")
                .content(objectMapper.writeValueAsString(driverObj3))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/driver")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(3))
                .andExpect(jsonPath("[0].firstName").value("Maria"))
                .andExpect(jsonPath("[2].wins").value("3"))
        ;


    }
}
