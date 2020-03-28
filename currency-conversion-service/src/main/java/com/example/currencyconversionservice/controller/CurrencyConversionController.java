package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.bean.CurrencyConversionBean;
import com.example.currencyconversionservice.proxy.CurrencyExchangeProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("currency-converter")
public class CurrencyConversionController {

    private final CurrencyExchangeProxy proxy;

    @GetMapping("from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class,
                uriVariables);
        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(),
                response.getFrom(),
                response.getTo(),
                response.getConversionMultiple(),
                amount,
                amount.multiply(response.getConversionMultiple()),
                response.getPort()
        );
    }

    @GetMapping("feignfrom/{from}/to/{to}/amount/{amount}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
        CurrencyConversionBean response = proxy.getExchangeRate(from, to);
        return new CurrencyConversionBean(response.getId(),
                response.getFrom(),
                response.getTo(),
                response.getConversionMultiple(),
                amount,
                amount.multiply(response.getConversionMultiple()),
                response.getPort()
        );
    }

}
