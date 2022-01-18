package com.app.apiaccessparty.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClientAcessBadRequest extends RuntimeException{

	private static final long serialVersionUID = -5902493483019456458L;
	
	public ClientAcessBadRequest(String message) {
		super(message);
	}

}
