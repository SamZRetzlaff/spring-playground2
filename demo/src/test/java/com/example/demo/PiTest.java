package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Pi.class)
public class PiTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testingPi() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
        }

    }
