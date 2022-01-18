package com.app.apiparty.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 2698189059594216336L;
	
	@Id
	private String id;
	
	private String codigoCliente;
	private String cpf;
	private String rg;
	private String nome;
	private String email;
	private String ddd;
	private String numCelular;
	private String codAcesso;

}
