package com.example.limitsservice.controller;

import com.example.limitsservice.bean.LimitConfiguration;
import com.example.limitsservice.config.Configuration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitsConfigurationController {

    private final Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
