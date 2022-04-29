package com.ssi.clean.example.uuid;

import com.ssi.clean.example.usecase.port.IdGenerator;
import java.util.UUID;

public class UuidGenerator implements IdGenerator {

	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
