package com.app.apiparty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.apiparty.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
	
	public Cliente findByCodigoCliente(String codigoCliente);
	
}
