package com.ssi.clean.example.usecase;

import com.ssi.clean.example.entity.User;
import com.ssi.clean.example.usecase.exception.UserAlreadyExistsException;
import com.ssi.clean.example.usecase.port.IdGenerator;
import com.ssi.clean.example.usecase.port.PasswordEncoder;
import com.ssi.clean.example.usecase.port.UserRepository;
import com.ssi.clean.example.usecase.validator.UserValidator;

public final class CreateUser {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final IdGenerator idGenerator;

	public CreateUser(final UserRepository repository, final PasswordEncoder passwordEncoder, final IdGenerator idGenerator) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.idGenerator = idGenerator;
	}

	public User create(final User user) {
		UserValidator.validateCreateUser(user);
		if (repository.findByEmail(user.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException(user.getEmail());
		}
		var userToSave = User.builder()
			.id(idGenerator.generate())
			.email(user.getEmail())
			.password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
			.lastName(user.getLastName())
			.firstName(user.getFirstName())
			.build();
		return repository.create(userToSave);
	}
}
