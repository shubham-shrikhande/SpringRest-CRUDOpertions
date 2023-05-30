package com.mt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_GATEWAY)
public class ActorNotFoundException extends Exception{

	public ActorNotFoundException() {
		super();
	}
	public ActorNotFoundException(String msg) {
		super();
	}
}
