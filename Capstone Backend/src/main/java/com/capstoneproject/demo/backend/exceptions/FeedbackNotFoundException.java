package com.capstoneproject.demo.backend.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class FeedbackNotFoundException extends RuntimeException {
	public FeedbackNotFoundException(String message) {
		super(message);
	}
}
