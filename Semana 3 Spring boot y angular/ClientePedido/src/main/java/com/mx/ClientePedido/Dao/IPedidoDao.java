package com.mx.ClientePedido.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mx.ClientePedido.Dominio.Pedido;


@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Integer> {
	
	//consultas personalizadas a la db
		//metodo que aplique una consulta personalizada a la db
		//buscar hijos por hobbie
		@Query ("SELECT p FROM Pedido p WHERE UPPER(p.fecha)= UPPER(:fecha)")
		
		public List<Pedido> findByFecha(@Param("fecha") String fecha);
		

}
