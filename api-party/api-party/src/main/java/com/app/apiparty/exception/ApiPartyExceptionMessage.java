package com.app.apiparty.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ApiPartyExceptionMessage {
	
	@Getter
	private LocalDateTime dataExcecao;
	@Getter
	private String message;
	@Getter
	private String detail;

}
