package com.mx.ClientePedido.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.ClientePedido.Dominio.Pedido;

@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Integer> {

    //Validación de pedido duplicado
    boolean existsByFechaAndMontoAndClienteId_IdCliente(
            String fecha,
            Integer monto,
            Integer idCliente
    );

    @Query("SELECT p FROM Pedido p WHERE UPPER(p.fecha) = UPPER(:fecha)")
    List<Pedido> findByFecha(@Param("fecha") String fecha);
}
