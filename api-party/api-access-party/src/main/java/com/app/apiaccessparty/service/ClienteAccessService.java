package com.app.apiaccessparty.service;

import java.util.List;

import com.app.apiaccessparty.model.ClienteAcess;

public interface ClienteAccessService {
	
	public List<ClienteAcess> exibirDadosCliente(String codigoCliente);
	
	public ClienteAcess addDadosAcesso(String codigoCliente);

}
