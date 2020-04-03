package com.example.mailservice;

import com.example.mailservice.config.MailSenderConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@AllArgsConstructor
@EnableFeignClients
@EnableDiscoveryClient
public class MailServiceApplication implements CommandLineRunner {
	private MailSenderConfig mailSenderConfig;

	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Sending Email...");
		mailSenderConfig.sendMail();
		System.out.println("Done");
	}

}
