package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.get;

@WebMvcTest(Calculator.class)
public class CalculatorTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testingAdd() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/caclculate?operation=add&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
    @Test
    public void testingSubtract() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/caclculate?operation=subtract&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }
    @Test
    public void testingMultiply() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/caclculate?operation=multiply&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }
    @Test
    public void testingDivide() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/caclculate?operation=divide&x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }
    @Test
    public void testingDefaultSum() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/caclculate?x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("35"));
    }

}
