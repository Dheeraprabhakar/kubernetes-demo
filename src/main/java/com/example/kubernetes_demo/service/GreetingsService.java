package com.example.kubernetes_demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;


@Service
public class GreetingsService {
    @Value("${SIMPLE_VAR:default simple var}")
    private String simple;
    public String greetUser(String username) {
        System.out.println("BLAH BLAH ...");
        LocalTime currentTime = LocalTime.now(Clock.system(ZoneId.of("America/Los_Angeles")));
        String greetingstime = currentTime.isAfter(LocalTime.NOON)?" afternoon ":" morning ";
        StringBuffer s = new StringBuffer("Good   ").append(greetingstime).append(username).append(". Theeee time now is "+currentTime.toString()).append(" . Now get lost and come back later to check time, or not...whatever. Get me a snack if you do. A good snack!").append(simple);
        //StringBuffer s = new StringBuffer("Good   ").append(username).append(". Theeee time now is ").append(" . Now get lost and come back later to check time, or not...whatever. Get me a snack if you do. A good snack!").append(simple);
        return s.toString();
    }
}
