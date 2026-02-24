package com.mx.Client;

//NOOO
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment =  WebEnvironment.RANDOM_PORT)
//indica al servidor spring en un puerto aleatrorio para evitar conflictos 
//Y esta anotacion crea un contexto de prueba completo para la aplicacion

public class TestBasicController {
	@LocalServerPort //inyecta el puerto asignado cuando se construya la url
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate; //permite enviar solicitudes http simuladas y obtener respuestas
	
	@Test
	void MensajeRetornoSaludo()throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port+"/", String.class))
		.contains("Hola mundo");//verifica si la peticion si devuelve texto
	}

}
