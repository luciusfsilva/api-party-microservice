package com.app.apiaccessparty.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.apiaccessparty.response.Cliente;

@FeignClient(name="api-party")
public interface ClientePartyProxy {
	
	@GetMapping("/api-party/{codigocliente}")
	public Cliente getClienteParty(@PathVariable("codigocliente") String codigocliente);

}
