package com.example.currencyconversionservice.proxy;

import com.example.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{initialCurrency}/to/{finalCurrency}")
    public CurrencyConversionBean getExchangeRate(@PathVariable("initialCurrency") String initialCurrency, @PathVariable("finalCurrency") String finalCurrency);

    }
