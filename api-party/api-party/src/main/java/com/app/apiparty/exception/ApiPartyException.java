package com.app.apiparty.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.apiparty.exception.exceptions.ClientNotContent;

@ControllerAdvice
@RestController
public class ApiPartyException extends ResponseEntityExceptionHandler{
	
	@Override
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiPartyExceptionMessage apiException = new ApiPartyExceptionMessage(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedOperationException.class)
	public final ResponseEntity<Object> handleBadRequestException(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request){
		ApiPartyExceptionMessage apiException = new ApiPartyExceptionMessage(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	@ExceptionHandler(ClientNotContent.class)
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiPartyExceptionMessage apiException = new ApiPartyExceptionMessage(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(apiException, HttpStatus.NO_CONTENT);
	}

}
