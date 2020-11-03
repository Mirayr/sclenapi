package com.mirayr.br.scleanapi.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    String  nome, telefone, cpf, cidade, bairro, rua, numero, complemento, email, observacao;

    @OneToMany(        
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Set<Pedido> pedidos = new HashSet<Pedido>();

    public void setPedido(Pedido pedido){
        pedidos.add(pedido);
        pedido.setCliente(this);                       
    }
}
