package com.example.coronacountries.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CoronaCountriesService {

    public List<String> getCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("China");
        countries.add("Australia");
        countries.add("USA");
        countries.add("Nepal");
        return countries;
    }


}
