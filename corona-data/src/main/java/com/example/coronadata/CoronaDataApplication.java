package com.example.coronadata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.coronadata")
public class CoronaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaDataApplication.class, args);
	}

}
