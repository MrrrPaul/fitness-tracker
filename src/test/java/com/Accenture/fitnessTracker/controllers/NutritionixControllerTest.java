package com.Accenture.fitnessTracker.controllers;

import com.Accenture.fitnessTracker.services.NutritionixService;
import com.Accenture.fitnessTracker.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;

class NutritionixControllerTest {

    @Mock
    private NutritionixService nutritionixService;

    @Mock
    private UserService userService;

    private WebTestClient webTestClient;

    private NutritionixController nutritionixController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        nutritionixController = new NutritionixController(nutritionixService, userService);
        webTestClient = WebTestClient.bindToController(nutritionixController).build();
    }

    @Test
    void queryNutritionixApi() throws Exception{
        webTestClient.get()
                .uri("/logger/product_query/some_food")
                .exchange()
                .expectStatus()
                .isOk();
    }
}