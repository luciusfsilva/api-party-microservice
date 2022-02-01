package com.app.apiaccessparty.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.apiaccessparty.response.Cliente;

@FeignClient(name="api-party")
public interface ClientePartyProxy {
	
	@GetMapping("/api-party")
	public Cliente getClienteParty(@RequestParam(name = "codcliente") String codcliente);

}
