package com.example.coronacountries.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
