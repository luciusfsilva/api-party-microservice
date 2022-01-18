package com.app.apiparty.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnsupportedOperationException extends RuntimeException{

	private static final long serialVersionUID = -2478365303816018434L;
	
	public UnsupportedOperationException(String message) {
		super(message);
	}

}
