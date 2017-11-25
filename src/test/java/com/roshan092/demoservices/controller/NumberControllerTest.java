package com.roshan092.demoservices.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200() throws Exception {
        int id = nextInt(1, 1000);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("id", id + "")).andReturn();
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturnCalculation() throws Exception {
        int id = nextInt(1, 1000);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("id", id + "")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        //language=JSON
        String expectedResponse = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"value\": " + (id * 100) + "\n" +
                "}";
        JSONAssert.assertEquals(expectedResponse, response, false);
    }
}
