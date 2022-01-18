package com.app.apiparty.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ClientNotContent extends RuntimeException{

	private static final long serialVersionUID = -6743597718081081388L;

	public ClientNotContent (String message) {
		super(message);
	}
}
