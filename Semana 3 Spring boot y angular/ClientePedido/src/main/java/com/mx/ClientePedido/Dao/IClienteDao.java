package com.mx.ClientePedido.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.ClientePedido.Dominio.Cliente;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer> {

	// metodo personalizado
	// buscar un padre por atributo
	@Query("SELECT c FROM Cliente c WHERE UPPER(c.ciudad) = UPPER(:ciudad)")
	public Cliente findByCiudadAllIgnoringCase(String ciudad);
	

}
