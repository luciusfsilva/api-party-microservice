package com.app.apiaccessparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.apiaccessparty.exception.exceptions.ClientAcessBadRequest;
import com.app.apiaccessparty.exception.exceptions.ClienteAcessNoContent;
import com.app.apiaccessparty.model.ClienteAcess;
import com.app.apiaccessparty.service.ClienteAccessService;

@RestController
@RequestMapping("api/access")
public class ClienteAccessPartyController {
	
	@Autowired
	private ClienteAccessService service;
	
	@GetMapping("/{codigocliente}")
	public ResponseEntity<Object> acessoCliente(@PathVariable("codigocliente") String codigocliente){
		ClienteAcess ca = service.exibirDadosCliente(codigocliente);
		if (ObjectUtils.isEmpty(ca)) throw new ClienteAcessNoContent("Cliente não encontrado");
		return ResponseEntity.ok(ca);
		
	}
	
	@PostMapping("/{codigocliente}")
	public ResponseEntity<Object> addAcessoCliente(@PathVariable("codigocliente") String codigocliente){
		ClienteAcess ca = service.addDadosAcesso(codigocliente);
		if (ObjectUtils.isEmpty(ca)) throw new ClientAcessBadRequest("Erro ao confirmar cliente");
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

}
