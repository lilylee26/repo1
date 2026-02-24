package com.mx.Curso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Curso.Entity.Usuario;
import com.mx.Curso.Repository.UsuarioRepository;
import com.mx.Curso.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(service.editar(id, usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/rol/{idRol}")
    public ResponseEntity<?> buscarPorRol(@PathVariable Long idRol) {
        try {
            return ResponseEntity.ok(service.buscarPorRol(idRol));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorTexto(@RequestParam String q) {
        try {
            return ResponseEntity.ok(service.buscarPorTexto(q));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(service.guardar(usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Usuario eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
