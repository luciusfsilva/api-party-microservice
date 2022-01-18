package com.app.apiaccessparty.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ClienteAcessNoContent extends RuntimeException{

	private static final long serialVersionUID = 5367237867299013593L;
	
	public ClienteAcessNoContent(String message) {
		super(message);
	}

}
