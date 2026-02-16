package com.mx.Pagos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Pagos.Entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

    public List<Pago> findByIdPedido(int idPedido);
    public List<Pago> findByTiendaId(int tiendaId);

}
