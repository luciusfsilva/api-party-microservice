package com.app.apiaccessparty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.apiaccessparty.model.EmailEnviado;

public interface ClienteEmailEnviado extends MongoRepository<EmailEnviado, String>{

}
