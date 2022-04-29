package com.ssi.clean.config;

import com.ssi.clean.example.db.hazelcast.HazelcastUserRepository;
import com.ssi.clean.example.usecase.port.PasswordEncoder;
import com.ssi.clean.example.usecase.port.UserRepository;
import com.ssi.clean.example.encoder.Sha256PasswordEncoder;
import com.ssi.clean.example.usecase.CreateUser;
import com.ssi.clean.example.usecase.FindUser;
import com.ssi.clean.example.usecase.LoginUser;
import com.ssi.clean.example.uuid.UuidGenerator;

public class SpringConfig {

	private final UserRepository userRepository = new HazelcastUserRepository();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, new UuidGenerator());
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
