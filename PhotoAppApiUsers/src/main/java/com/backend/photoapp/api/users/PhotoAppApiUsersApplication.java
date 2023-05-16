package com.backend.photoapp.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //This will make spring application client with discovery server
public class PhotoAppApiUsersApplication {
	/*
	User microservice will handle:
	Create new user
	User login (User login can also be handled by a seperate microservice such as Authentication microservice, but to keep it simple we will user it here)
	New User details
	Update user details
	Delete user details
	 */
	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsersApplication.class, args);
	}

}
