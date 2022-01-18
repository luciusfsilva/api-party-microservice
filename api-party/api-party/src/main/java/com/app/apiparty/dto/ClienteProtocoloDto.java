package com.app.apiparty.dto;

import com.app.apiparty.model.Cliente;
import com.app.apiparty.model.ClienteProtocolo;

import lombok.Getter;
import lombok.Setter;

public class ClienteProtocoloDto {
	
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String codigoCliente;
	@Getter @Setter
	private String protocolo;
	@Getter @Setter
	private String dataHoraCadastro;
	
	public ClienteProtocoloDto(Cliente cliente, ClienteProtocolo clienteProtocolo) {
		super();
		this.nome = cliente.getNome();
		this.codigoCliente = clienteProtocolo.getCodigoCliente();
		this.protocolo = clienteProtocolo.getProtocolo();
		this.dataHoraCadastro = clienteProtocolo.getDataHoraCadastro();
	}
	
	

}
