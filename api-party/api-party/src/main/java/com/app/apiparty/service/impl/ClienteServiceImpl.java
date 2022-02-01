package com.app.apiparty.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.app.apiparty.dto.ClienteProtocoloDto;
import com.app.apiparty.model.Cliente;
import com.app.apiparty.model.ClienteProtocolo;
import com.app.apiparty.repository.ClienteProtocoloRepository;
import com.app.apiparty.repository.ClienteRepository;
import com.app.apiparty.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteProtocoloRepository protocoloRepository;
	
	//@Autowired
	//private ModelMapper modelMapper;

	@Override
	public ClienteProtocoloDto exibirCliente(String codcliente) {
		ClienteProtocolo cp = protocoloRepository.findByCodigoCliente(codcliente);
		Cliente c = repository.findByCodigoCliente(codcliente);
		//return modelMapper.map(cp, ClienteProtocoloDto.class);
		return new ClienteProtocoloDto(c, cp);
	}

	@Override
	public List<ClienteProtocolo> listarClientes() {
		return protocoloRepository.findAll();
	}

	@Override
	public Cliente addNovoCliente(Cliente cliente) {
		Integer codigocliente = new Random().nextInt();
		codigocliente = codigocliente < 0 ? codigocliente * (-1) : codigocliente;
		cliente.setCodigoCliente(codigocliente.toString());
		Cliente c = repository.save(cliente);
		if (!ObjectUtils.isEmpty(c)) {
			Integer protocolo = new Random().nextInt(); 
			ClienteProtocolo cp = ClienteProtocolo.builder().codigoCliente(c.getCodigoCliente())
					.protocolo(protocolo.toString())
					.dataHoraCadastro(LocalDateTime.now().toString())
					.build();
			protocoloRepository.save(cp);
		}
		return c;
	}

}
