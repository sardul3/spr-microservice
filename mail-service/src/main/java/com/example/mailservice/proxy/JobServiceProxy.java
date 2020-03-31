package com.example.mailservice.config.proxy;

import com.example.mailservice.model.Job;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="jobs-service")
public interface JobServiceProxy {

    @GetMapping
    public List<Job> getJobs();
}
