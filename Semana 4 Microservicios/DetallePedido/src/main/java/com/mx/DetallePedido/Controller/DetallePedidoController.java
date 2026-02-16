package com.mx.DetallePedido.Controller;

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

import com.mx.DetallePedido.Entity.DetallePedido;
import com.mx.DetallePedido.Service.DetallePedidoService;


@RestController
@RequestMapping(path = "/DP")
@CrossOrigin
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        if (service.listar().isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(service.listar());
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody DetallePedido detalle) {
        service.guardar(detalle);
        return ResponseEntity.ok("Guardado");
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody DetallePedido detalle) {
        if (service.buscar(detalle.getIdDetalle()) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        } else {
            service.editar(detalle);
            return ResponseEntity.ok("Editado");
        }
    }

    @DeleteMapping("{idDetalle}")
    public ResponseEntity<?> eliminar(@PathVariable int idDetalle) {
        if (service.buscar(idDetalle) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        } else {
            service.eliminar(idDetalle);
            return ResponseEntity.ok("Eliminado");
        }
    }

    @GetMapping(path = "{idDetalle}")
    public ResponseEntity<?> buscar(@PathVariable int idDetalle) {
        if (service.buscar(idDetalle) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
        } else {
            return ResponseEntity.ok(service.buscar(idDetalle));
        }
    }

    @GetMapping(path = "listarPorPedido/{idPedido}")
    public ResponseEntity<?> listarPorPedido(@PathVariable int idPedido) {
        return ResponseEntity.ok(service.listarPorPedido(idPedido));
    }

    @GetMapping(path = "listarPorProducto/{idProducto}")
    public ResponseEntity<?> listarPorProducto(@PathVariable int idProducto) {
        return ResponseEntity.ok(service.listarPorProducto(idProducto));
    }
    
    @GetMapping(path = "listarPorTienda/{tiendaId}")
    public ResponseEntity<?> listarPorTienda(@PathVariable int tiendaId){
        return ResponseEntity.ok(service.listarPorTienda(tiendaId));
    }


}
