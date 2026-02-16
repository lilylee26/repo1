package com.mx.Client.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Client.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	// listar por tienda
	List<Producto> findByTiendaId(Integer tiendaId);

	// validar duplicado al GUARDAR
	boolean existsByNombreIgnoreCaseAndTiendaId(String nombre, Integer tiendaId);

	// validar duplicado al EDITAR (ignorando el mismo id)
	boolean existsByNombreIgnoreCaseAndTiendaIdAndIdProductoNot(String nombre, Integer tiendaId, Integer idProducto);
}
