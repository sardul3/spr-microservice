package com.example.coronadata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoronaData {
    private String country;
    private int totalCases;
    private int totalDeath;
    private int totalRecovered;
}
