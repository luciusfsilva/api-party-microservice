package com.app.apiaccessparty.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 7456019685914408529L;

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
