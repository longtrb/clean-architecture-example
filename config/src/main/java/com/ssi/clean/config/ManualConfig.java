package com.ssi.clean.config;

import com.ssi.clean.example.db.InMemoryUserRepository;
import com.ssi.clean.example.usecase.port.IdGenerator;
import com.ssi.clean.example.usecase.port.PasswordEncoder;
import com.ssi.clean.example.usecase.port.UserRepository;
import com.ssi.clean.example.encoder.Sha256PasswordEncoder;
import com.ssi.clean.example.jug.JugIdGenerator;
import com.ssi.clean.example.usecase.CreateUser;
import com.ssi.clean.example.usecase.FindUser;
import com.ssi.clean.example.usecase.LoginUser;

public class ManualConfig {
	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, idGenerator);
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
