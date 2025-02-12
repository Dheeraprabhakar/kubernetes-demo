package com.example.kubernetes_demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = GreetingsService.class)
class GreetingsServiceTest {
    @Autowired
    GreetingsService greetingsService;

    @Test
    void greetUser() {
        String x = greetingsService.greetUser("ABCDEFGJG");
        System.out.println("response from service: " + x);
        assertNotNull(x);
    }
}