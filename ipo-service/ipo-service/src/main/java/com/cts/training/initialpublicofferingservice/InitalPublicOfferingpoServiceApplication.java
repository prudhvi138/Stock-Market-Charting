package com.cts.training.initialpublicofferingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InitalPublicOfferingpoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitalPublicOfferingpoServiceApplication.class, args);
	}

}
