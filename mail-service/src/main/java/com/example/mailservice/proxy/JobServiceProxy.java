package com.example.mailservice.proxy;

import com.example.mailservice.model.Job;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="jobs-service")
@EnableCircuitBreaker
public interface JobServiceProxy {

    @GetMapping
     List<Job> getJobs();
}
