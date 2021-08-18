package com.komidev.sharebook.controller;

import com.komidev.sharebook.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@SpringBootTest
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    public void retrieveAllUser_basic() throws Exception {
        Mockito.when(service.getUsers()).thenReturn(Arrays.asList());
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
