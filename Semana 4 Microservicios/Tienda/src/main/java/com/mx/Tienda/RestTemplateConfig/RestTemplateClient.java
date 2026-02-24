package com.mx.Tienda.RestTemplateConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//indica que mi clase es una fuente de configuaracion y debe tener por lo menos un bean

@Configuration
public class RestTemplateClient {

	@Bean
	
	RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	
	//RestTemplate es una clase que me ofrece java, para poder realizar peticiones http
	//es decir convierte a mi MicroServicio como un cliente HTTP para poder realizar
	//peticiones y consumir otros Microservicios

	
}
