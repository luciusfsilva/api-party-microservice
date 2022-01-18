package com.app.apiaccessparty.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("clienteaccess")
public class ClienteAcess {
	
	@Id
	private String id;
	
	private String codigoAcesso;
	private String codigoCliente;
	private String acessoEnviado;
	private String emailConfirmEnviado;

}
