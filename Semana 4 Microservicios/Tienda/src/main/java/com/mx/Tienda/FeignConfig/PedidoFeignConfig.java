package com.mx.Tienda.FeignConfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Tienda.DTOs.PedidoDTO;

@FeignClient(name = "Pedido", url = "http://localhost:8004/PP")
public interface PedidoFeignConfig {

    @GetMapping("listarPTienda/{tiendaId}")
    public List<PedidoDTO> listarPorTienda(@PathVariable int tiendaId);

}

