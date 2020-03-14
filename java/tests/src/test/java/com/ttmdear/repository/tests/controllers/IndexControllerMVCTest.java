package com.ttmdear.repository.tests.controllers;

import com.ttmdear.repository.tests.controllers.IndexController;
import com.ttmdear.repository.tests.repositories.UserRepository;
import com.ttmdear.repository.tests.repositories.impl.UserRepositoryImpl;
import com.ttmdear.repository.tests.services.UserService;
import com.ttmdear.repository.tests.services.impl.UserServiceImpl;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IndexControllerMVCTest {
    IndexController indexController;

    UserService userService;

    UserRepository userRepository;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        UserRepository userRepository = new UserRepositoryImpl();

        userService = new UserServiceImpl(userRepository);

        indexController = new IndexController(userService);
    }

    @Test
    public void routeUsersUser() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        MvcResult mvcResult = mockMvc.perform(get("/api/users/967a0a57-ba3e-4276-b2fe-1e340582bca2").accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id", new IsEqual<>("967a0a57-ba3e-4276-b2fe-1e340582bca2")))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
