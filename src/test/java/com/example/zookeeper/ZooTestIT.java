package com.example.zookeeper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.PersistenceUnit;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooTestIT {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addAnimalTest() throws Exception {
        ArrayList<AnimalDto> animals = new ArrayList<>();
        animals.add(new AnimalDto("Tiger", "walking"));
        mockMvc.perform(post("/animals")
        .content(objectMapper.writeValueAsString(animals)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
        );
        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("Tiger"))
                .andExpect(jsonPath("[0].type").value("walking"));
    }

    @Test
    public void addAnimalsTest() throws Exception {
        ArrayList<AnimalDto> animals = new ArrayList<>();
        animals.add(new AnimalDto("Peacock", "flying"));
        animals.add(new AnimalDto("Tuna", "swimming"));

        mockMvc.perform(post("/animals")
                .content(objectMapper.writeValueAsString(animals)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );
        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(3))
                .andExpect(jsonPath("[1].name").value("Peacock"))
                .andExpect(jsonPath("[1].type").value("flying"))
                .andExpect(jsonPath("[2].name").value("Tuna"))
                .andExpect(jsonPath("[2].type").value("swimming"));

    }



}
