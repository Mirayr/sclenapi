package com.mirayr.br.scleanapi.controller;

import java.util.List;

import com.mirayr.br.scleanapi.repository.ClienteRepository;
import com.mirayr.br.scleanapi.models.Cliente;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Api(value = "API Rest de Cliente")
@RestController
public class ClienteResources {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Retona uma lista de Clientes")
    public List<Cliente> listaCliente() {
        return clienteRepository.findAll();
    }

    @GetMapping(value = "/cliente/{id}", produces = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Retorna um unico cliente")
    public Cliente listaClienteUnico(@PathVariable(value = "id") long id) {
        return clienteRepository.findById(id);
    }

    @PostMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Salva Cliente")
    public Cliente salvaCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Apaga Cleinte existente")
    public void deletaCliente(@RequestBody Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Atualiza Cliente existente")
    public Cliente atualizaCliente(@RequestBody Cliente cliente) {
        System.out.println("Recebido o objeto cliente abixo: ");
        System.out.println(cliente.getNome());
        System.out.println(cliente.getComplemento());
        return clienteRepository.save(cliente);
    }
}
