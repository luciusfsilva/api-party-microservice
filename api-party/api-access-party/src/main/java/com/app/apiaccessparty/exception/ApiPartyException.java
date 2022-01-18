package com.app.apiaccessparty.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.apiaccessparty.exception.exceptions.ClientAcessBadRequest;
import com.app.apiaccessparty.exception.exceptions.ClienteAcessNoContent;

@ControllerAdvice
@RestController
public class ApiPartyException extends ResponseEntityExceptionHandler{

	@Override
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ClienteAccessException cae = new ClienteAccessException(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(cae, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	@ExceptionHandler(ClientAcessBadRequest.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ClienteAccessException cae = new ClienteAccessException(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(cae, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	@ExceptionHandler(ClienteAcessNoContent.class)
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ClienteAccessException cae = new ClienteAccessException(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(cae, HttpStatus.NO_CONTENT);
	}
	
	
	
}
