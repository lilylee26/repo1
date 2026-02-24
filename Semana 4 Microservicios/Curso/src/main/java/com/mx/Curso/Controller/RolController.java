package com.mx.Curso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Curso.Entity.Rol;
import com.mx.Curso.Repository.RolRepository;
import com.mx.Curso.Service.RolService;

@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RolController {

    @Autowired
    private RolRepository repo;

    @Autowired
    private RolService service;

    @GetMapping
    public List<Rol> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Rol rol) {
        try {
            return ResponseEntity.ok(service.guardar(rol));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Rol rol) {
        try {
            return ResponseEntity.ok(service.editar(id, rol));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Rol eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
