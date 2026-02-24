package com.mx.Curso.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.Curso.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Duplicado por atributos (nombre+app+apm)
    boolean existsByNombreAndAppAndApm(String nombre, String app, String apm);

    // Buscar usuarios por rol
    List<Usuario> findByRol_IdRol(Long idRol);

    // Buscar usuarios por texto 
    List<Usuario> findByNombreContainingIgnoreCaseOrAppContainingIgnoreCaseOrApmContainingIgnoreCase(
            String nombre, String app, String apm
    );

    // Para evitar borrar un rol si está en uso
    boolean existsByRol_IdRol(Long idRol);
}
