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
import javax.persistence.criteria.Fetch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servico")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Servico implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nome;
    @Column
    private BigDecimal valor_base;
    @Column
    private String descricao;

    @ManyToMany(    fetch = FetchType.LAZY
                    //,cascade = CascadeType.ALL
    )
    @JoinTable(
        name = "pedido_servico",
        joinColumns = {@JoinColumn(name = "servico_id")},
        inverseJoinColumns = {@JoinColumn(name = "pedido_id")}
    )
    private Set<Pedido> pedidos = new HashSet<Pedido>();

    public void setPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void removePedido(Pedido pedido){
        this.pedidos.remove(pedido);
    }

    public void setPedidos(Set<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public Set<Pedido> getPedidos(){
        return this.pedidos;
    }
}
