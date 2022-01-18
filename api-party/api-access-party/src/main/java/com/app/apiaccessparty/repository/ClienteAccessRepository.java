package com.app.apiaccessparty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.apiaccessparty.model.ClienteAcess;

public interface ClienteAccessRepository extends MongoRepository<ClienteAcess, String>{
	
	ClienteAcess findByCodigoCliente(String codigoCliente);
	
}
