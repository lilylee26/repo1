package com.mx.Pagos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Pagos.Entity.Pago;
import com.mx.Pagos.Service.PagoService;

@RestController
@RequestMapping(path = "/PG")
@CrossOrigin
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        if(service.listar().isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(service.listar());
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Pago pago){
        service.guardar(pago);
        return ResponseEntity.ok("Guardado");
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Pago pago){
        if(service.buscar(pago.getIdPago()) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        } else {
            service.editar(pago);
            return ResponseEntity.ok("Editado");
        }
    }

    @DeleteMapping("{idPago}")
    public ResponseEntity<?> eliminar(@PathVariable int idPago){
        if(service.buscar(idPago) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        } else {
            service.eliminar(idPago);
            return ResponseEntity.ok("Eliminado");
        }
    }

    @GetMapping(path = "{idPago}")
    public ResponseEntity<?> buscar(@PathVariable int idPago){
        if(service.buscar(idPago) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        } else {
            return ResponseEntity.ok(service.buscar(idPago));
        }
    }

    @GetMapping(path = "listarPorPedido/{idPedido}")
    public ResponseEntity<?> listarPorPedido(@PathVariable int idPedido){
        return ResponseEntity.ok(service.listarPorPedido(idPedido));
    }

    @GetMapping(path = "listarPorTienda/{tiendaId}")
    public ResponseEntity<?> listarPorTienda(@PathVariable int tiendaId){
        return ResponseEntity.ok(service.listarPorTienda(tiendaId));
    }
}
