package com.example.coronadata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoronaData {
    private String country;
    private String totalCases;
    private String newCases;
    private String totalDeath;
    private String newDeath;
    private String totalRecovered;
    private String activeCases;
    private String seriousCases;
}
