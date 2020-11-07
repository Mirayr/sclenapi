package com.mirayr.br.scleanapi.repository;

import com.mirayr.br.scleanapi.models.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PedidoRepository extends JpaRepository <Pedido, Long>{
    Pedido findById(long id);    
}
