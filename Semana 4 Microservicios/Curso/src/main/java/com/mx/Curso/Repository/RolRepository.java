package com.mx.Curso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.Curso.Entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    boolean existsByPrivilegio(String privilegio);
}
