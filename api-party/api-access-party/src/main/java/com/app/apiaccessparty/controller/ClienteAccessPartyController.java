package com.app.apiaccessparty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.apiaccessparty.exception.exceptions.ClientAcessBadRequest;
import com.app.apiaccessparty.exception.exceptions.ClienteAcessNoContent;
import com.app.apiaccessparty.model.ClienteAcess;
import com.app.apiaccessparty.service.ClienteAccessService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Client Acess Party endpoint")
@RestController
@RequestMapping("api-access-party")
@CrossOrigin(origins = "*")
public class ClienteAccessPartyController {
	
	@Autowired
	private ClienteAccessService service;
	
	@GetMapping("/cliente/{codigocliente}")
	@Operation(summary = "Get Client Acess Party!")
	public ResponseEntity<List<ClienteAcess>> acessoCliente(@PathVariable String codigocliente){
		List<ClienteAcess> ca = service.exibirDadosCliente(codigocliente);
		if (ObjectUtils.isEmpty(ca)) throw new ClienteAcessNoContent("Cliente não encontrado");
		return ResponseEntity.ok(ca);
		
	}
	
	@PostMapping("/add/{codigocliente}")
	@Operation(summary = "Post Client Acess Party!")
	public ResponseEntity<Object> addAcessoCliente(@PathVariable String codigocliente){
		ClienteAcess ca = service.addDadosAcesso(codigocliente);
		if (ObjectUtils.isEmpty(ca)) throw new ClientAcessBadRequest("Erro ao confirmar cliente");
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

}
