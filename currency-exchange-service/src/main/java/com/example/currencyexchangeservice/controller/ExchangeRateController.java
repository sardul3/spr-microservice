package com.example.currencyexchangeservice.controller;

import com.example.currencyexchangeservice.bean.ExchangeValue;
import com.example.currencyexchangeservice.service.ExchangeValueService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
@RequestMapping("currency-exchange")
public class ExchangeRateController {
    private final ExchangeValueService exchangeValueService;

    @GetMapping("from/{initialCurrency}/to/{finalCurrency}")
    public ExchangeValue getExchangeRate(@PathVariable String initialCurrency, @PathVariable String finalCurrency) {
            return exchangeValueService.getConversionFactor(initialCurrency, finalCurrency);
    }
}
