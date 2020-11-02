package com.mirayr.br.scleanapi.models;

import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

// import org.springframework.data.jpa.repository.Temporal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "data_pedido")
    @javax.persistence.Temporal(TemporalType.DATE)
    private Date dataPedido;    
    
    

    
    private java.util.Date parseDate(String date) {
        final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void setDataPedido(String date){
        this.dataPedido = parseDate(date);
    }

    public Date getDataPedido(){
        return this.dataPedido;
    }

    public Pedido(String data){
        this.dataPedido = parseDate(data);
    }

}
