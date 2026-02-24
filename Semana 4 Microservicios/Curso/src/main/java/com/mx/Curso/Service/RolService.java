package com.mx.Curso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Curso.Entity.Rol;
import com.mx.Curso.Repository.RolRepository;
import com.mx.Curso.Repository.UsuarioRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public Rol guardar(Rol rol) {

        if (rol == null || rol.getPrivilegio() == null || rol.getPrivilegio().trim().isEmpty()) {
            throw new RuntimeException("El privilegio es obligatorio");
        }

        String privilegio = rol.getPrivilegio().trim();

        if (repo.existsByPrivilegio(privilegio)) {
            throw new RuntimeException("Rol duplicado");
        }

        rol.setPrivilegio(privilegio);
        return repo.save(rol);
    }
    
    
    public Rol editar(Long idRol, Rol rol) {

        if (idRol == null) throw new RuntimeException("IdRol obligatorio");

        Rol rolBD = repo.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no existe"));

        if (rol.getPrivilegio() == null || rol.getPrivilegio().trim().isEmpty()) {
            throw new RuntimeException("El privilegio es obligatorio");
        }

        String nuevoPrivilegio = rol.getPrivilegio().trim();

        // si cambió el nombre, validar duplicado
        if (!rolBD.getPrivilegio().equalsIgnoreCase(nuevoPrivilegio)
                && repo.existsByPrivilegio(nuevoPrivilegio)) {
            throw new RuntimeException("Rol duplicado");
        }

        rolBD.setPrivilegio(nuevoPrivilegio);
        return repo.save(rolBD);
    }


    public void eliminar(Long idRol) {
        if (idRol == null) throw new RuntimeException("IdRol obligatorio");

        repo.findById(idRol).orElseThrow(() -> new RuntimeException("Rol no existe"));

        if (usuarioRepo.existsByRol_IdRol(idRol)) {
            throw new RuntimeException("No se puede eliminar: el rol está asignado a usuarios");
        }

        repo.deleteById(idRol);
    }
}
