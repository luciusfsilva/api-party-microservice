package com.app.apiparty.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("clienteprotocolo")
public class ClienteProtocolo implements Serializable{
	
	private static final long serialVersionUID = 513025627954277004L;

	@Id
	private String id;
	
	private String protocolo;
	private String codigoCliente;
	private String dataHoraCadastro;

}
