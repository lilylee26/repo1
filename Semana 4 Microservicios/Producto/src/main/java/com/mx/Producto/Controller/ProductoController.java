package com.mx.Producto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Producto.Entity.Producto;
import com.mx.Producto.Service.ProductoService;

@RestController
@RequestMapping("/P")
@CrossOrigin
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        if (service.listar().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto producto) {

        boolean duplicado = service.existeProducto(producto.getNombre(), producto.getTiendaId());
        if (duplicado) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ese producto ya existe en esa tienda");
        }

        service.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto registrado con exito");
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<?> buscar(@PathVariable Integer idProducto) {
        Producto p = service.buscar(idProducto);
        if (p == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el producto");
        }
        return ResponseEntity.ok(p);
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Producto producto) {

        Producto existente = service.buscar(producto.getIdProducto());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el producto para editar");
        }

        boolean duplicado = service.existeProductoEditar(
                producto.getNombre(),
                producto.getTiendaId(),
                producto.getIdProducto()
        );

        if (duplicado) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ese producto ya existe en esa tienda");
        }

        service.editar(producto);
        return ResponseEntity.ok("Editado con exito");
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idProducto) {

        Producto p = service.buscar(idProducto);
        if (p == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el producto");
        }

        service.eliminar(idProducto);
        return ResponseEntity.ok("Eliminado con exito");
    }

    @GetMapping("/tienda/{idTienda}")
    public ResponseEntity<?> listarPorTienda(@PathVariable Integer idTienda) {
        if (service.listarPorTienda(idTienda).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(service.listarPorTienda(idTienda));
    }
    
    // STOCK
    @PutMapping("/stock/{idProducto}/{cambio}")
    public ResponseEntity<?> ajustarStock(@PathVariable Integer idProducto, @PathVariable int cambio) {

        String r = service.ajustarStock(idProducto, cambio);

        if (r.equals("No existe")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(r);
        }

        if (r.equals("Stock insuficiente")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(r);
        }

        return ResponseEntity.ok(r);
    }
}
