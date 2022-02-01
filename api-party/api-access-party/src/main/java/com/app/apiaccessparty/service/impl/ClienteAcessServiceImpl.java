package com.app.apiaccessparty.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.apiaccessparty.model.ClienteAcess;
import com.app.apiaccessparty.model.EmailEnviado;
import com.app.apiaccessparty.proxy.ClientePartyProxy;
import com.app.apiaccessparty.repository.ClienteAccessRepository;
import com.app.apiaccessparty.repository.ClienteEmailEnviado;
import com.app.apiaccessparty.response.Cliente;
import com.app.apiaccessparty.service.ClienteAccessService;

@Service
public class ClienteAcessServiceImpl implements ClienteAccessService{
	
	@Autowired
	private ClienteAccessRepository repository;
	
	@Autowired
	private ClienteEmailEnviado emailEnviado;
	
	@Autowired
	private ClientePartyProxy proxy;
	
	@Autowired
	private JavaMailSender email;

	@Override
	public List<ClienteAcess> exibirDadosCliente(String codigoCliente) {
		return repository.findByCodigoCliente(codigoCliente);
	}

	@Override
	public ClienteAcess addDadosAcesso(String codigoCliente) {
		ClienteAcess acessoLiberado = preencherDadosAcesso(codigoCliente);
		return repository.save(acessoLiberado);
	}

	private ClienteAcess preencherDadosAcesso(String codigocliente) {
		Cliente cliente = proxy.getClienteParty(codigocliente);
		Integer codigoAcesso = new Random().nextInt();
		var codigoCliente = cliente.getCodigoCliente();
		var acessoEnviado = acessoEnviado(cliente, codigoAcesso.toString());
		return ClienteAcess.builder().codigoAcesso(codigoAcesso.toString()).codigoCliente(codigoCliente)
				.acessoEnviado(acessoEnviado.toString())
				.emailConfirmEnviado(acessoEnviado.toString())
				.build();
	}

	//Serviço de SMS tem que pagar, então fiz uma simulação.
	private Boolean acessoEnviado(Cliente cliente, String codAcesso) {
		Boolean envioSms = true;
		Boolean envioEmailConfirmacao = false;
		if (envioSms) {
			confirmacaoEnvio(cliente, codAcesso);
			envioEmailConfirmacao = true;
			return envioEmailConfirmacao;
		}
		return envioEmailConfirmacao;
	}
	
	private Boolean confirmacaoEnvio(Cliente cliente, String codAcesso) {
		Boolean confEnvio = false;
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("appjavaservertest52@yahoo.com");
			message.setTo(cliente.getEmail());
			message.setSubject("Código de acesso confirmado");
			message.setText("Cliente de código " + cliente.getCodigoCliente() + ", validado com sucesso no sistema com acesso: " + codAcesso + ".");
			email.send(message);
			EmailEnviado em = EmailEnviado.builder()
					.emailFrom(message.getFrom())
					.emailTo(message.getTo().toString())
					.subject(message.getSubject())
					.text(message.getText())
					.sendDateEmail(LocalDateTime.now())
					.statusEmail(true)
					.build();
			emailEnviado.save(em);
			confEnvio = true;
		}catch(MailException e) {
			confEnvio = false;
		}
		return confEnvio;
	}

}
