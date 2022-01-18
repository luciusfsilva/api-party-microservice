package br.com.app.apinamingserverparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApiNamingServerPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNamingServerPartyApplication.class, args);
	}

}
