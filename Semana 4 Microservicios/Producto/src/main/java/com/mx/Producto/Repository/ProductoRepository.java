package com.mx.Producto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.Producto.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	// listar por tienda
	List<Producto> findByTiendaId(Integer tiendaId);

	// validar duplicado al GUARDAR
	boolean existsByNombreIgnoreCaseAndTiendaId(String nombre, Integer tiendaId);

	// validar duplicado al EDITAR (ignorando el mismo id)
	boolean existsByNombreIgnoreCaseAndTiendaIdAndIdProductoNot(String nombre, Integer tiendaId, Integer idProducto);
	
	
	@Modifying
	@Query("UPDATE Producto p SET p.stock = :stock WHERE p.idProducto = :id")
	int actualizarStock(@Param("id") Integer id, @Param("stock") Integer stock);

}
