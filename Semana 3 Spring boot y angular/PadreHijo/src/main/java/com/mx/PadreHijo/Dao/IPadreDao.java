package com.mx.PadreHijo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.PadreHijo.Dominio.Padre;

@Repository
public interface IPadreDao extends JpaRepository<Padre, Integer> {

    //metodo personalizado
    //buscar un padre por atributo
    @Query("SELECT p FROM Padre p WHERE UPPER(p.nombre) = UPPER(:nombre)")
    public Padre findByNombreAllIgnoringCase(String nombre);
	
	
	
	

}
