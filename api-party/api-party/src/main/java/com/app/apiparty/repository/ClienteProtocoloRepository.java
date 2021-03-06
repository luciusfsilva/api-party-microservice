package com.app.apiparty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.apiparty.model.ClienteProtocolo;

public interface ClienteProtocoloRepository extends MongoRepository<ClienteProtocolo, String>{

	public ClienteProtocolo findByCodigoCliente(String codigoCliente);
}
