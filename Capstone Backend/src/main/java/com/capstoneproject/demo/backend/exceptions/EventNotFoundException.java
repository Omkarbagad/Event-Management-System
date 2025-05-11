package com.capstoneproject.demo.backend.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException {
	public EventNotFoundException(String message) {
		super(message);
	}
}