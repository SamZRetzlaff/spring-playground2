package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(Calculator.class)
public class CalculatorTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testingAdd() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
    @Test
    public void testingSubtract() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }
    @Test
    public void testingMultiply() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }
    @Test
    public void testingDivide() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }
    @Test
    public void testingDefaultSum() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("35"));
    }
//    @Test
//    public void testingArraySum() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/math/sum?n=2&n=3&n=4");
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string("9"));
//    }
    @Test
    public void testingVolume() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/volume/3/4/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("60"));
    }
    @Test
    public void testingVolumePost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("60"));
    }
    @Test
    public void testingVolumePatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/math/volume/3/4/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("60"));
    }
    @Test
    public void testRectangle() throws Exception {
        String expectedString = "Area: 15";

        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "5")
                .param("height", "3");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }
    @Test
    public void testCircle() throws Exception {
        String expectedString = "Area: 28.274333882308138";

        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "3");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }
}
