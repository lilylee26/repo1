package com.mx.Farmacia.Controller;

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

import com.mx.Farmacia.Dominio.Medicamento;
import com.mx.Farmacia.Service.MedicamentoService;

@RestController // configura la clase como un web services y no spermite
//utilizar el protocolo http (solicitudes [request] y respuestas [response])
@RequestMapping(path = "api/Med") // para especifica la ruta de mis controladores
//para que cunado el clietne haga una peticion, tenga el nombre espcifico de mi url
//anotarlo de este lado de la clas es como ponerlo como un prefijo
@CrossOrigin // permite que los dominios puedan hacer peticiones de mi clase de controlador

public class MedicamentoController {
	@Autowired

	private MedicamentoService service;

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

	// guardar -> http://localhost:8003/api/compu/guardar
	@PostMapping(path = "guardar")
	public void guardar(@RequestBody Medicamento medicamento) {
		service.guardar(medicamento);
	}

	// http://localhost:8003/api/Med/aumStock/1/10
//	@PostMapping("/aumStock/{idMed}/{cantidad}")
//	public ResponseEntity<String> aumStock(@PathVariable int idMed, @PathVariable int cantidad) {
//	    service.aumStock(idMed, cantidad);
//	    return ResponseEntity.ok("El medicamento se agrego correctamente");
//	}

	// http://localhost:8003/api/Med/aumStock?pIdMed=1&pCantidad=50
	@PostMapping("/aumStock")
	public ResponseEntity<String> aumStock(@RequestParam Integer pIdMed, @RequestParam Integer pCantidad) {
		try {
			service.aumStock(pIdMed, pCantidad);
			return ResponseEntity
					.ok("Se aumentó el stock del medicamento " + pIdMed + " con " + pCantidad + " unidades más");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ocurrió un error: " + e.getMessage());
		}
	}

	// http://localhost:8003/api/Med/venMedicamento/1/10
	@PostMapping("/venMedicamento/{idMed}/{cantidad}")
	public ResponseEntity<String> aumStock(@PathVariable int idMed, @PathVariable int cantidad) {
		service.venMedicamento(idMed, cantidad);
		return ResponseEntity.ok("El medicamento se desconto correctamente");
	}

	// http://localhost:8003/api/Med/venMedicamento?pIdMed=1&pCantidad=50
//	@PostMapping("/venMedicamento")
//	public ResponseEntity<String> venMedicamento(@RequestParam Integer pIdMed, @RequestParam Integer pCantidad) {
//	    try {
//	        service.venMedicamento(pIdMed, pCantidad);
//	        return ResponseEntity.ok("Se disminuyo el stock del medicamento " + pIdMed + " con " + pCantidad + " unidades menos");
//	    } catch (Exception e) {
//	        return ResponseEntity.badRequest().body("Ocurrió un error: " + e.getMessage());
//	    }
//	}

	// http://localhost:8003/api/Med/eliminar/3
	@DeleteMapping("/eliminar/{idMed}")
	public ResponseEntity<String> eliminar(@PathVariable Integer idMed) {
		service.eliminarMed(idMed);
		return ResponseEntity.ok("Medicamento eliminado correctamente");
	}

	// http://localhost:8003/api/Med/descLab?pLab=PFIZER&pDescuento=10
	@PostMapping("/descLab")
	public ResponseEntity<String> descLab(@RequestParam String pLab, @RequestParam Integer pDescuento) {
		service.descLab(pLab, pDescuento);
		return ResponseEntity.ok("Se aplicó descuento " + pDescuento + "% al laboratorio " + pLab);
	}
	
	
	
	

	// GET / DELETE → PathVariable
	// POST / PUT → RequestBody

	// GET /api/compu/listar
	// POST /api/compu/guardar
	// PUT /api/compu/editar
	// POST /api/compu/buscar/{id}
	// DELETE /api/compu/eliminar/{id}

}
