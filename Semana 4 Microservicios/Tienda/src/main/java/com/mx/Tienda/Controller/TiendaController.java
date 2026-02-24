
package com.mx.Tienda.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Tienda.DTOs.ClienteDTO;
import com.mx.Tienda.DTOs.PedidoDTO;
import com.mx.Tienda.DTOs.ProductoDTO;
import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.Service.TiendaService;

@RestController
@RequestMapping("/Tienda")
//@CrossOrigin
public class TiendaController {

    @Autowired
    private TiendaService service;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Tienda>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // GUARDAR
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tienda tienda) {
        service.guardar(tienda);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se guardó");
    }

    // BUSCAR POR ID (para cargar en editar)
    @GetMapping("/{idTienda}")
    public ResponseEntity<?> buscarPorId(@PathVariable int idTienda) {
        Tienda encontrada = service.buscar(idTienda);
        if (encontrada == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(encontrada);
    }

    // ✅ EDITAR
    @PutMapping("/{idTienda}")
    public ResponseEntity<?> editar(@PathVariable int idTienda, @RequestBody Tienda tienda) {
        Tienda encontrada = service.buscar(idTienda);
        if (encontrada == null) return ResponseEntity.notFound().build();

        // amarrar el id de la URL al objeto
        tienda.setIdTienda(idTienda);

        service.editar(tienda);
        return ResponseEntity.ok("Se editó");
    }

    // ELIMINAR
    @DeleteMapping("/{idTienda}")
    public ResponseEntity<?> eliminar(@PathVariable int idTienda) {
        Tienda encontrada = service.buscar(idTienda);
        if (encontrada == null) return ResponseEntity.notFound().build();

        service.eliminar(idTienda);
        return ResponseEntity.ok("Se eliminó");
    }

    @GetMapping("clientes/{tiendaId}")
    public ResponseEntity<?> clientesPTienda(@PathVariable Integer tiendaId) {
        try {
            Tienda encontrada = service.buscar(tiendaId);
            if (encontrada == null) return ResponseEntity.notFound().build();

            List<ClienteDTO> clientes = service.listarClientes(tiendaId);
            if (clientes.isEmpty()) return ResponseEntity.noContent().build();

            return ResponseEntity.ok(clientes);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("EL servicio del cliente no está disponible");
        }
    }

    @GetMapping("pedidosrt/{tiendaId}")
    public ResponseEntity<?> pedidosPorTienda(@PathVariable Integer tiendaId) {
        try {
            Tienda encontrada = service.buscar(tiendaId);
            if (encontrada == null) return ResponseEntity.notFound().build();

            List<PedidoDTO> pedidos = service.listarPedidos(tiendaId);
            if (pedidos.isEmpty()) return ResponseEntity.noContent().build();

            return ResponseEntity.ok(pedidos);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("El servicio de pedido no está disponible");
        }
    }

    @GetMapping("productort/{tiendaId}")
    public ResponseEntity<?> productosPorTienda(@PathVariable Integer tiendaId) {
        try {
            Tienda encontrada = service.buscar(tiendaId);
            if (encontrada == null) return ResponseEntity.notFound().build();

            List<ProductoDTO> productos = service.listarProductos(tiendaId);
            if (productos.isEmpty()) return ResponseEntity.noContent().build();

            return ResponseEntity.ok(productos);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("El servicio de productos no está disponible");
        }
    }

    @GetMapping("todo/{tiendaId}")
    public ResponseEntity<?> listarTodo(@PathVariable int tiendaId) {
        Map<String, Object> todo = service.listarTodo(tiendaId);
        return ResponseEntity.ok(todo);
    }
}