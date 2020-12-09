package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetFlightController.class)

public class GetFlightControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testFlight1() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/flights/flight");
        this.mvc.perform(request)
//                get("/flights/flight")
//                    .accept(MediaType.APPLICATION_JSON_UTF8)
//                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is ("2017-04-21 14:34")))
                .andExpect(jsonPath("$.price", is ("200")))
                .andExpect(jsonPath("$.firstName", is ("Some name")))
                .andExpect(jsonPath("$.lastName", is ("Some other name")))
;
    }
}

