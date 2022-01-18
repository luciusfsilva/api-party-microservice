package com.app.apiparty.service;

import java.util.List;

import com.app.apiparty.dto.ClienteProtocoloDto;
import com.app.apiparty.model.Cliente;
import com.app.apiparty.model.ClienteProtocolo;

public interface ClienteService {
	
	public ClienteProtocoloDto exibirCliente(String codcliente);
	
	public List<ClienteProtocolo> listarClientes();
	
	public Cliente addNovoCliente(Cliente cliente);

}
