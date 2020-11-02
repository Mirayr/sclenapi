package com.mirayr.br.scleanapi.repository;

import com.mirayr.br.scleanapi.models.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Cliente findById(long id);
}
