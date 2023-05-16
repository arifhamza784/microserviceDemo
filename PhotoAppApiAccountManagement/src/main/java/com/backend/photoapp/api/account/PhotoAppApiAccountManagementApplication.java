package com.backend.photoapp.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //To make this application client of eureka server
public class PhotoAppApiAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccountManagementApplication.class, args);
	}

}
