package repo.spring.tests.controllers;

import repo.spring.tests.repositories.UserRepository;
import repo.spring.tests.repositories.UserRepositoryImpl;
import repo.spring.tests.services.UserService;
import repo.spring.tests.services.UserServiceImpl;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IndexControllerMVCTest {
    IndexController indexController;
    MockMvc mockMvc;
    UserRepository userRepository;
    UserService userService;

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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        UserRepository userRepository = new UserRepositoryImpl();

        userService = new UserServiceImpl(userRepository);

        indexController = new IndexController(userService);
    }
}
