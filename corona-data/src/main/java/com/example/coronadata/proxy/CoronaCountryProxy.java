package com.example.coronadata.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="corona-countries")
@RibbonClient(name="corona-countries")
public interface CoronaCountryProxy {
    @GetMapping()
    public List<String> getCountries();
}
