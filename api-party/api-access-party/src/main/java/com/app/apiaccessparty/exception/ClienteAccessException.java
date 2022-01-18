package com.app.apiaccessparty.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data	
public class ClienteAccessException implements Serializable{
	
	private static final long serialVersionUID = 8375803732244333391L;
	
	private LocalDateTime dataHoraException;
	private String message;
	private String detail;
	
	public ClienteAccessException(LocalDateTime dataHoraException, String message, String detail) {
		this.dataHoraException = dataHoraException;
		this.message = message;
		this.detail = detail;
	}
	
	
}
