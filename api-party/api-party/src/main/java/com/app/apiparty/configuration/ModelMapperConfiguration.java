package com.app.apiparty.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.apiparty.dto.ClienteProtocoloDto;

@Configuration
public class ModelMapperConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(ClienteProtocoloDto.class, ClienteProtocoloDto.class)
			.<String>addMapping(src -> src.getNome(), (dest, value) -> dest.setNome(value));
		
		return modelMapper;
	}

}
