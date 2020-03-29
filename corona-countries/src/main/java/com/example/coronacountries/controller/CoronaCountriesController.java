package com.example.coronacountries.controller;

import com.example.coronacountries.service.CoronaCountriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CoronaCountriesController {

    private final CoronaCountriesService coronaCountriesService;

    @GetMapping()
    public List<String> getCountries() {
        return coronaCountriesService.getCountries();
    }
}
