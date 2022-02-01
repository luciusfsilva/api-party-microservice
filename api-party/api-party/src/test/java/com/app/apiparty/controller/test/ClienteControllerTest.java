package com.app.apiparty.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.apiparty.controller.ClienteController;
import com.app.apiparty.dto.ClienteProtocoloDto;
import com.app.apiparty.model.Cliente;
import com.app.apiparty.model.ClienteProtocolo;
import com.app.apiparty.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@WebMvcTest
public class ClienteControllerTest {
	
	private ObjectMapper mapper= new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ClienteController controller;
	
	@MockBean
	private ClienteService service;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void exibirTodosClientes_SUCCESS() throws Exception {
		List<ClienteProtocolo> cls = protocolos();
		Mockito.when(service.listarClientes()).thenReturn(cls);
		
		mockMvc.perform(get("/api-party/all")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	public void exibirTodosClientes_NO_CONTENT() throws Exception {
		Mockito.when(service.listarClientes()).thenReturn(null);
		
		mockMvc.perform(get("/api-party/all")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
			.andExpect(status().isNoContent());
		
	}
	
	@Test
	public void exibirClienteProtocoloDto_SUCCESS() throws Exception {
		ClienteProtocoloDto protocolo = clienteDto();
		Mockito.when(service.exibirCliente("920309542")).thenReturn(protocolo);
		
		mockMvc.perform(get("/api-party/").param("codcliente", "920309542")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void exibirClienteProtocoloDto_NO_CONTENT() throws Exception {
		Mockito.when(service.exibirCliente(null)).thenReturn(null);
		
		mockMvc.perform(get("/api-party/").param("codcliente", "aaaaa")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void exibirClienteProtocoloDto_BAD_REQUEST() throws Exception {
		mockMvc.perform(get("/api-party/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void addNovoCliente_SUCCESS() throws Exception {
		Cliente cliente = cliente();
		Mockito.when(service.addNovoCliente(cliente)).thenReturn(cliente);
		
		mockMvc.perform(post("/api-party")
				.content(mapper.writeValueAsString(cliente))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
			.andExpect(status().isCreated());
	}
	
	@Test
	public void addNovoCliente_BAD_REQUEST() throws Exception {
		
		mockMvc.perform(post("/api-party")
				.content(mapper.writeValueAsString(null))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
			.andExpect(status().isBadRequest());
		
	}
	
	public List<ClienteProtocolo> protocolos() {
		List<ClienteProtocolo> cls = new ArrayList<>();
		
		ClienteProtocolo cp1= ClienteProtocolo.builder().id("61e964996ee4fe02a811c1d2")
				.protocolo("307146766")
				.codigoCliente("-738562261")
				.dataHoraCadastro("2022-01-20T10:32:39.280099900").build();
		cls.add(cp1);
		
		ClienteProtocolo cp2= ClienteProtocolo.builder().id("61e964996ee4fe02a811c1d2")
				.protocolo("307146766")
				.codigoCliente("-738562261")
				.dataHoraCadastro("2022-01-20T10:32:39.280099900").build();
		cls.add(cp2);
		
		return cls;
	}
	
	public Cliente cliente() {
		Cliente c = Cliente.builder().id("11111").cpf("97296179708").rg("264941548").nome("Geraldo Vinicius Santos")
				.email("appjavaservertest52@yahoo.com").ddd("21").numCelular("995698430").build();
		return c;
	}
	
	public ClienteProtocoloDto clienteDto() {
		
		Cliente c = Cliente.builder().id("11111").cpf("97296179708").rg("264941548").nome("Geraldo Vinicius Santos")
				.email("appjavaservertest52@yahoo.com").ddd("21").numCelular("995698430").build();
		
		ClienteProtocolo cp1= ClienteProtocolo.builder().id("61e964996ee4fe02a811c1d2")
				.protocolo("307146766")
				.codigoCliente("-738562261")
				.dataHoraCadastro("2022-01-20T10:32:39.280099900").build();
		
		ClienteProtocoloDto dto = new ClienteProtocoloDto(c, cp1);
		return dto;
	}


}
