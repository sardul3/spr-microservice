package com.example.coronadata.controller;

import com.example.coronadata.model.CoronaData;
import com.example.coronadata.proxy.CoronaCountryProxy;
import com.example.coronadata.service.CoronaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CoronaController {

    private final CoronaService coronaService;

    @GetMapping
    public List<CoronaData> getCoronaData() {
        return coronaService.getData();
    }

    @GetMapping("all")
    public List<CoronaData>  getAll() {
        return coronaService.scrapeData();
    }
}
