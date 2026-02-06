package com.mx.ClientePedido.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.ClientePedido.Dominio.Cliente;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer> {

	// metodo personalizado
	// buscar un padre por atributo


    Optional<Cliente> findByNombreIgnoreCaseAndCiudadIgnoreCase(String nombre, String ciudad);

    // ✅ Query personalizada: buscar clientes por ciudad (ignorando mayúsculas)
    @Query("SELECT c FROM Cliente c WHERE UPPER(c.ciudad) = UPPER(:ciudad)")
    List<Cliente> buscarPorCiudad(@Param("ciudad") String ciudad);
    public Cliente findByCiudadAllIgnoringCase(String ciudad);

}
