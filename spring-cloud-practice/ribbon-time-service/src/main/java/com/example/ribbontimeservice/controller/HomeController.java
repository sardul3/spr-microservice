package com.example.ribbontimeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class HomeController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String getHome() {
        return "Current time: " + new Date().toString() + "\n From: " + port;
    }
}
