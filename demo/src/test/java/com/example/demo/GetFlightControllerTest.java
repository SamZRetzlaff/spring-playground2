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
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is ("2017-04-21 14:34")))
                .andExpect(jsonPath("$.ticket.price", is ("200")))
                .andExpect(jsonPath("$.ticket.passenger.firstName", is ("Some name")))
                .andExpect(jsonPath("$.ticket.passenger.lastName", is ("Some other name")));
    }
    @Test
    public void testFlight1and2() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/flights");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].departs", is ("2017-04-21 14:34")))
                .andExpect(jsonPath("$[0].ticket.price", is ("200")))
                .andExpect(jsonPath("$[0].ticket.passenger.firstName", is ("Some name")))
                .andExpect(jsonPath("$[0].ticket.passenger.lastName", is ("Some other name")))
                .andExpect(jsonPath("$[1].departs", is ("2017-08-25 01:00")))
                .andExpect(jsonPath("$[1].ticket.price", is ("300")))
                .andExpect(jsonPath("$[1].ticket.passenger.firstName", is ("Some name2")))
                .andExpect(jsonPath("$[1].ticket.passenger.lastName", is ("Some other name2")));
    }


}

