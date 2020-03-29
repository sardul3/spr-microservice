package com.example.coronadata.service;
import com.example.coronadata.model.CoronaData;
import com.example.coronadata.proxy.CoronaCountryProxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CoronaService {
    private final CoronaCountryProxy coronaCountryProxy;

    public List<CoronaData> getData() {
        List<String> countries = coronaCountryProxy.getCountries();
        List<CoronaData> data = new ArrayList<>();
        countries.forEach(country -> {
            data.add(new CoronaData(country, (int)(Math.random() * ((1000 - 30) + 1)) + 30, (int)(Math.random() * ((300 - 230) + 1)) + 130, (int)(Math.random() * ((190 - 10) + 1)) + 10));
        });
        return data;
    }
}