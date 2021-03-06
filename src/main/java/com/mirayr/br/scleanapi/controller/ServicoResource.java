package com.mirayr.br.scleanapi.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.mirayr.br.scleanapi.models.Servico;
import com.mirayr.br.scleanapi.repository.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;





@RestController
@RequestMapping("/api")
@Api(value="API REST de Servicos")
@CrossOrigin(value = "*")
public class ServicoResource {
    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping(value = "/servicos", produces = MediaType.APPLICATION_JSON)
    @ApiOperation(value="Retorna uma lista de Serviços")
    public List<Servico> listaServicos(){
        return servicoRepository.findAll();
    }

    @GetMapping(value = "/servico/{id}", produces = MediaType.APPLICATION_JSON)
    @ApiOperation(value="Retorna um unico Serviço")
    public Servico listaServicoUnico(@PathVariable(value="id") long id) {
        return servicoRepository.findById(id);
    }

    @PostMapping(value = "/servico", consumes = MediaType.APPLICATION_JSON)
    @ApiOperation(value="Salva um Serviço novo")
    public Servico salvaServico(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }
    
    @DeleteMapping(value = "/servico", consumes = MediaType.APPLICATION_JSON)
    @ApiOperation(value="Apaga um Serviço Existente")
    public void deletaServico(@RequestBody Servico servico) {
        servicoRepository.delete(servico);
    }

    @PutMapping(value = "/servico", consumes = MediaType.APPLICATION_JSON)
    @ApiOperation(value="Atualiza um Serviço existente")
    public Servico atualizaServico(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }
}
