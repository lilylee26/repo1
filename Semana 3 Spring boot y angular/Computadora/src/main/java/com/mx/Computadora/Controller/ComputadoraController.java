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
import org.springframework.web.bind.annotation.RestController;

import com.mx.Computadora.Dominio.Computadora;
import com.mx.Computadora.Service.ComputadoraService;

@RestController // configura la clase como un web services y no spermite
//utilizar el protocolo http (solicitudes [request] y respuestas [response])
@RequestMapping(path = "api/Compu") // para especifica la ruta de mis controladores
//para que cunado el clietne haga una peticion, tenga el nombre espcifico de mi url
//anotarlo de este lado de la clas es como ponerlo como un prefijo
@CrossOrigin // permite que los dominios puedan hacer peticiones de mi clase de controlador

public class ComputadoraController {

	@Autowired

	private ComputadoraService service;

	// son para especificar que el metodo que realice es un metodo controlador
	// especifica la ruta de mi metodo que podra ser consumido, especificamente
	// MEGMAPPIN,
	// me ayuda a indicar que el consumo sera a traves de una solicitud de tipo GET,
	// con la
	// url + (posiblemente un recurso extra y sin ningun body y los encabezados por
	// defecto

	@GetMapping(path = "listar")
	public ResponseEntity<?> listar() {
		if (service.listar().isEmpty()) {
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.ok(service.listar());
		}
	}

	// guardar -> http://localhost:8000/api/compu/guardar
	@PostMapping(path = "guardar")
	public void guardar(@RequestBody Computadora computadora) {
		service.guardar(computadora);
	}

	// editar --> http://localhost:8000/api/compu/editar
	@PutMapping(path = "editar")
	public void editar(@RequestBody Computadora computadora) {
		service.editar(computadora);
	}
	
	// buscar --> http://localhost:8000/api/compu/buscar/18
	@PostMapping(path = "buscar/{idComputadora}")
	public Computadora buscar(@PathVariable int idComputadora) {
		return service.buscar(idComputadora);
	}

	// eliminar -->http://localhost:8000/api/compu/eliminar/17
	@DeleteMapping(path = "eliminar/{idComputadora}")
	public void eliminar(@PathVariable int idComputadora) {
		service.eliminar(idComputadora);
	}
	
	@PostMapping("/aplicarDescuento")
	public ResponseEntity<?> aplicarDescuento(@RequestParam Integer pDescuento){
		try {
			service.aplicarDescuento(pDescuento);
			return ResponseEntity.ok("Descuento del " + pDescuento + "% aplicado exitosamente");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("Ocurrio un error" + e.getMessage());
		}
	}
	
	
	
	
	
	//GET / DELETE → PathVariable
	//POST / PUT → RequestBody
	
	//	GET     /api/compu/listar
	//	POST    /api/compu/guardar
	//	PUT     /api/compu/editar
	//	POST    /api/compu/buscar/{id}
	//	DELETE  /api/compu/eliminar/{id}

}
