package com.Accenture.fitnessTracker.controllers;

import com.Accenture.fitnessTracker.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class IndexControllerTest {

    private IndexController indexController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(userService);
    }

    @Test
    void homepage() throws Exception {
    }
}
