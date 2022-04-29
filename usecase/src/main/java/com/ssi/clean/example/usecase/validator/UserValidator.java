package com.ssi.clean.example.usecase.validator;

import com.ssi.clean.example.entity.User;
import com.ssi.clean.example.usecase.exception.UserValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class UserValidator {

	public static void validateCreateUser(final User user) {
		if (user == null) throw new UserValidationException("User should not be null");
		if (isBlank(user.getEmail())) throw new UserValidationException("Email should not be null");
		if (isBlank(user.getFirstName())) throw new UserValidationException("First name should not be null");
		if (isBlank(user.getLastName())) throw new UserValidationException("Last name should not be null");
	}

	private UserValidator() {

	}
}
