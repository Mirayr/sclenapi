package com.mirayr.br.scleanapi.controller;

import java.util.List;

import com.mirayr.br.scleanapi.repository.ClienteRepository;
import com.mirayr.br.scleanapi.models.Cliente;

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
@RequestMapping(value = "/api")
@Api(value="API Rest de Cliente")
@CrossOrigin(origins="*")
public class ClienteResources {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    @ApiOperation(value="Retona uma lista de Clientes")
    public List<Cliente> listaCliente(){
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente/{id}")
    @ApiOperation(value="Retorna um unico cliente")
    public Cliente listaClienteUnico(@PathVariable(value="id") long id){
        return clienteRepository.findById(id);
    }

    @PostMapping("/cliente")
    @ApiOperation(value="Salva Cliente")
    public Cliente salvaCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/cliente")
    @ApiOperation(value="Apaga Cleinte existente")
    public void deletaCliente(@RequestBody Cliente cliente){
        clienteRepository.delete(cliente);
    }

    @PutMapping("/cliente")
    @ApiOperation(value="Atualiza Cliente existente")
    public Cliente atualizaCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
