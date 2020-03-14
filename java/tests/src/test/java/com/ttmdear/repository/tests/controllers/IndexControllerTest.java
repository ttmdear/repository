package com.ttmdear.repository.tests.controllers;

import com.ttmdear.repository.tests.domain.User;
import com.ttmdear.repository.tests.domain.UserStatus;
import com.ttmdear.repository.tests.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {
    @Mock
    private UserService userService;

    @Mock
    private Model model;

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(userService);
    }

    @Test
    void index() {
        Set<User> users = new HashSet<>();

        users.add(new User("1", "Paweł", "Kowalski", UserStatus.ACTIVE));
        users.add(new User("2", "Justyna", "Iksińska", UserStatus.ACTIVE));
        users.add(new User("3", "Kasia", "Jankowiak", UserStatus.ACTIVE));

        when(userService.find()).thenReturn(users);

        String result = indexController.index(model);

        verify(userService, times(1)).find();
        verify(model, times(1)).addAttribute("users", users);

        assertEquals("index", result);
    }
}