package com.ppm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdentifierException extends RuntimeException {

	private static final long serialVersionUID = 6946247164985285711L;

	public ProjectIdentifierException(String message, Exception e) {
		super(message);
	}

	
}
