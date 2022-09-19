package com.example.boots_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.boots_api.users.User;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BootsApiApplication {

	List<User> users = new ArrayList<User>(); // {{user1},{user2}}

	public static void main(String[] args) {
		SpringApplication.run(BootsApiApplication.class, args);
	}

}
