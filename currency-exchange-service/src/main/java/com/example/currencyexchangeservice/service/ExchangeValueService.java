package com.example.currencyexchangeservice.service;

import com.example.currencyexchangeservice.bean.ExchangeValue;
import com.example.currencyexchangeservice.repository.ExchangeValueRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ExchangeValueService {

    private final Environment environment;
    private final ExchangeValueRepository exchangeValueRepository;


    public ExchangeValue getConversionFactor(String from, String to) {
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        ExchangeValue exchangeValue =  exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(port);
        return exchangeValue;
    }

}
