package com.mirayr.br.scleanapi.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "servico")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Servico implements Serializable{
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @Column
    public String nome;
    @Column
    public BigDecimal valor_base;
    @Column
    public String descricao;

    @ManyToMany(    fetch = FetchType.LAZY,
                    cascade = CascadeType.REMOVE
    )
    @JoinTable(
        name = "pedido_servico",
        joinColumns = {@JoinColumn(name = "servico_id")},
        inverseJoinColumns = {@JoinColumn(name = "pedido_id")}
    )
    @JsonBackReference("servicos")
    public Set<Pedido> pedidos_in_services = new HashSet<Pedido>();

    public void setPedido(Pedido pedido){
        this.pedidos_in_services.add(pedido);
    }

    public void removePedido(Pedido pedido){
        this.pedidos_in_services.remove(pedido);
    }

    public void setpedidos(Set<Pedido> pedidos){
        this.pedidos_in_services = pedidos;
    }

    public Set<Pedido> getpedidos(){
        return this.pedidos_in_services;
    }

    public Servico(){}

    public Servico(long id, String nome, BigDecimal valor_base, String descricao, Set<Pedido> pedidos_in_services) 
    {
        this.id = id;
        this.nome = nome;
        this.valor_base = valor_base;
        this.descricao = descricao;
        this.pedidos_in_services = pedidos_in_services;
    }
    
}
