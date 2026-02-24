package com.mx.Client.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//indidca que es clase controlador, se usa cuando necesitamos
//majear vista html se puede usar cuando se aplica todo lo de una aplicacion alojado en el servidor (server)
//back y front

public class PruebaController {
	
	@GetMapping("/")
	public @ResponseBody String Saludo() {
		return "Hola mundo";
	}

}
