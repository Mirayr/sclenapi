package com.mirayr.br.scleanapi.repository;

import com.mirayr.br.scleanapi.models.Servico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository <Servico, Long>{
    Servico findById(long id);
}
