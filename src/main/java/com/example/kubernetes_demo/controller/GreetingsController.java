package com.example.kubernetes_demo.controller;
import com.example.kubernetes_demo.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {
    @Autowired
    private GreetingsService greetingsService;

    @GetMapping("/greet")
    public String greetUser(@RequestParam String username) {
        System.out.println("HELLOWORLD!!!!!!!!!!!!!!!");
        return greetingsService.greetUser(username);
    }
}
