package com.app.apiparty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.apiparty.dto.ClienteProtocoloDto;
import com.app.apiparty.exception.exceptions.ClientNotContent;
import com.app.apiparty.model.Cliente;
import com.app.apiparty.model.ClienteProtocolo;
import com.app.apiparty.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Api party endpoint")
@RestController
@RequestMapping("api-party")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	@Operation(summary = "Get Api party from client!")
	public ResponseEntity<Object> infoCliente(@RequestParam(name = "codcliente") String codcliente){
		ClienteProtocoloDto retorno = service.exibirCliente(codcliente.toString());
		if (ObjectUtils.isEmpty(retorno)) throw new ClientNotContent("Cliente não encontrado"); 
		return ResponseEntity.ok(retorno);
	}
	
	@GetMapping("/all")
	@Operation(summary = "Get Api party all from client!")
	public ResponseEntity<Object> listInfoClientes(){
		List<ClienteProtocolo> retorno = service.listarClientes();
		if (ObjectUtils.isEmpty(retorno)) throw new ClientNotContent("Cliente (s) não encontrado (s)"); 
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	@Operation(summary = "Post Api party from client!")
	public ResponseEntity<Object> addClientes(@RequestBody Cliente cliente){
		Cliente retorno = service.addNovoCliente(cliente);
		if (ObjectUtils.isEmpty(retorno)) throw new UnsupportedOperationException("Não foi possível inclusão"); 
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
