package com.ssi.clean.config;

import com.ssi.clean.example.db.InMemoryUserRepository;
import com.ssi.clean.example.encoder.Sha256PasswordEncoder;
import com.ssi.clean.example.jug.JugIdGenerator;
import com.ssi.clean.example.usecase.CreateUser;
import com.ssi.clean.example.usecase.FindUser;
import com.ssi.clean.example.usecase.LoginUser;
import com.ssi.clean.example.usecase.port.IdGenerator;
import com.ssi.clean.example.usecase.port.PasswordEncoder;
import com.ssi.clean.example.usecase.port.UserRepository;

public class VertxConfig {

	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
	private final CreateUser createUser = new CreateUser(userRepository, passwordEncoder, idGenerator);
	private final FindUser findUser = new FindUser(userRepository);
	private final LoginUser loginUser = new LoginUser(userRepository, passwordEncoder);

	public CreateUser createUser() {
		return createUser;
	}

	public FindUser findUser() {
		return findUser;
	}

	public LoginUser loginUser() {
		return loginUser;
	}
}
