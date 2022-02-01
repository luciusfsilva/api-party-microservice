package com.app.apiaccessparty.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.apiaccessparty.model.ClienteAcess;

public interface ClienteAccessRepository extends MongoRepository<ClienteAcess, String>{
	
	public List<ClienteAcess> findByCodigoCliente(String codigoCliente);
	
}
