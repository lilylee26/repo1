package com.mx.Computadora.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Computadora.Dominio.Computadora;
import com.mx.Computadora.Service.ComputadoraService;

@RestController//configura la clase como un web Services y nos permite 
//utilizar el protcolo http(solicitudes [requests] y respuestas[response])
@RequestMapping(path = "api/Compu") //especifica la ruta de mis controladores, para que 
//cuando el cliente haga una peticion, tenga el nombre especifico de mi url, 
//anotarlo en este lado clase es como poner un prefijo(lada), 
@CrossOrigin//permite que los dominios puedan hacer petciones de mi clase contralador
public class ComputadoraController {
	
	@Autowired
	private ComputadoraService service;
	//esoecifica la ruta de mi metodo que podra se consumirdo, especificamente GetMapping, me 
	//ayuda indicar, que el consumor sera a traves de una solicitud de tipo GET, con la
	//url + (posibliemente un recurso extra) y sin ningun body y los encabezados por defecto
	@GetMapping(path = "listar")
	public ResponseEntity<?> listar(){
		if(service.listar().isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(service.listar());
		}
	}
	
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Computadora computadora){
		service.guardar(computadora);
		return ResponseEntity.ok("Se guardo con exito");
	}
	
	@PutMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Computadora computadora){
		service.editar(computadora);
		return ResponseEntity.ok("Se edito con exito");
	}
	
	@DeleteMapping("eliminar/{idCompu}")
	public ResponseEntity<?> eliminar(@PathVariable int idCompu){
		service.eliminar(idCompu);
		return ResponseEntity.ok("Se elimino con exito");
	}
	
	@GetMapping("buscar/{idCompu}")
	public ResponseEntity<?> buscar(@PathVariable int idCompu){
		
		return ResponseEntity.ok(service.buscar(idCompu));
	}
	
	@PostMapping("/aplicarDescuento")
	public ResponseEntity<?> aplicarDescuento(@RequestParam Integer pDescuento){
		try {
			service.aplicarDescuento(pDescuento);
			return ResponseEntity.ok("Descuento del "+pDescuento+"% aplicado existosamente");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("Ocurrio un error " + e.getMessage());
		}
	}

}
