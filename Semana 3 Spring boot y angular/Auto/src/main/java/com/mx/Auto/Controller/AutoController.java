package com.mx.Auto.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.mx.Auto.Dominio.Auto;
import com.mx.Auto.Service.AutoServiceImp;
@RestController //es una anotacion que indica que mi clase es una clase controlador y que manejara
//peticiones http y retornara las respuestas
@RequestMapping(path = "api/auto") //indica la ruta de mi clase controlador y que todos mis metodos
//controladores de esta clase llevaran dicha ruta
@CrossOrigin //configura el cors para que lod dominios puedan acceder a mi clase controlador y
//los metodos, (esta configuracion solo debe ser para pruebas, nunca para produccion)

public class AutoController {
	
	//Inyectar la logica de negocios
		@Autowired
		private AutoServiceImp service;
		//crear los metodos que vamos a poder consumir desde otra parte
		/*
		 * URL:PROTOCOLO://HOST:PUERTO/PATH
		 * URL LIBRO:
		 * http://localhost:8000/api/auto
		 * */
		
		//listar: http://localhost:8000/api/auto/listar
		@GetMapping(path = "listar")
		public List<Auto> listar(){
			return service.mostrar();
		}
		
		//guardar  ->http://localhost:8000/api/auto/guardar
		@PostMapping(path="guardar")
		public void guardar(@RequestBody Auto auto) {
			service.guardar(auto);
		}
		
		
		//editar --> http://localhost:8000/api/auto/editar
		@PutMapping(path = "editar")
		public void editar(@RequestBody Auto auto) {
			service.editar(auto);
		}
		
		//buscar --> http://localhost:8000/api/auto/buscar
		@PostMapping (path ="buscar")
		public Auto buscar(@RequestBody Auto auto) {
			return service.buscar(auto);

		}
		
		//eliminar -->http://localhost:8000/api/auto/eliminar
		@DeleteMapping(path ="eliminar")
		public void eliminar(@RequestBody Auto auto) {
			service.eliminar(auto);
		}
		
		
	

}
