package com.app.apiaccessparty.service;

import com.app.apiaccessparty.model.ClienteAcess;

public interface ClienteAccessService {
	
	public ClienteAcess exibirDadosCliente(String codigoCliente);
	
	public ClienteAcess addDadosAcesso(String codigoCliente);

}
