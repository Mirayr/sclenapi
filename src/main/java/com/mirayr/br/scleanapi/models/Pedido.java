package com.mirayr.br.scleanapi.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Pedido")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "cliente" }, allowSetters = true)
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "data_pedido")
    @javax.persistence.Temporal(TemporalType.DATE)
    private Date dataPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty("cliente")        
    private Cliente cliente;

    @ManyToMany(mappedBy = "pedidos_in_services", // Nome do Set criado na tabela Servico
            fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @JsonBackReference("pedidos_in_services")
    private Set<Servico> servicos = new HashSet<Servico>();

    private java.util.Date parseDate(String date) {
        final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void setServico(Servico servico) {
        this.servicos.add(servico);
        servico.setPedido(this);
    }

    public void removeServico(Servico servico) {
        this.servicos.remove(servico);
        servico.getpedidos().remove(this);
    }

    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

    public Set<Servico> getServicos() {
        return this.servicos;
    }

    public long getId() {
        return this.id;
    }

    public void setDataPedido(String date) {
        this.dataPedido = parseDate(date);
    }

    public Date getDataPedido() {
        return this.dataPedido;
    }

    // Pedido(String data) {
    //     this.dataPedido = parseDate(data);
    // }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @JsonBackReference("pedidos")
    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pedido))
            return false;
        return (id != 0l) && id == (((Pedido) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public Pedido(){}

    public Pedido(long id, Date dataPedido, Cliente cliente, Set<Servico> servicos) 
    {
        this.id = id;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.servicos = servicos;
    }
    
}
