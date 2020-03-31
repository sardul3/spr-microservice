package com.example.jobsservice.controller;

import com.example.mailservice.model.Job;
import com.example.jobsservice.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class JobController {
    private JobService jobService;

    @GetMapping
    public List<Job> getJobs(){
        return jobService.fetchJobs();
    }
}
