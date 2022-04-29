package com.ssi.clean.example;

import com.ssi.clean.config.ManualConfig;
import com.ssi.clean.example.entity.User;

public class Main {
	public static void main(String[] args) {
		// Setup
		var config = new ManualConfig();
		var createUser = config.createUser();
		var findUser = config.findUser();
		var loginUser = config.loginUser();
		var user = User.builder()
			.email("longtb@ssi.com.vn")
			.password("mypassword")
			.lastName("long")
			.firstName("tb")
			.build();

		// Create a user
		var actualCreateUser = createUser.create(user);
		System.out.println("User created with id " + actualCreateUser.getId());

		// Find a user by id
		var actualFindUser = findUser.findById(actualCreateUser.getId());
		System.out.println("Found user with id " + actualFindUser.get().getId());

		// List all users
		var users = findUser.findAllUsers();
		System.out.println("List all users: " + users);

		// Login
		loginUser.login("longtb@ssi.com.vn", "mypassword");
		System.out.println("Allowed to login with email 'longtb@ssi.com.vn' and password  'mypassword'");
	}
}
