/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nando Cortez
 */
@Entity
@Table(name = "tbl_mensagem")
public class Mensagem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cod_msg;
    private String titulo_msg;
    private String conteudo_msg;
    private String tipo_msg;
    private String status;
    private Date data_msg = new Date(System.currentTimeMillis());
    private Long cod_dest;
    

    public Long getCod_msg() {
        return cod_msg;
    }

    public void setCod_msg(Long cod_msg) {
        this.cod_msg = cod_msg;
    }

    public String getTitulo_msg() {
        return titulo_msg;
    }

    public void setTitulo_msg(String titulo_msg) {
        this.titulo_msg = titulo_msg;
    }

    public String getConteudo_msg() {
        return conteudo_msg;
    }

    public void setConteudo_msg(String conteudo_msg) {
        this.conteudo_msg = conteudo_msg;
    }

    public String getTipo_msg() {
        return tipo_msg;
    }

    public void setTipo_msg(String tipo_msg) {
        this.tipo_msg = tipo_msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_msg() {
        return data_msg;
    }

    public void setData_msg(Date data_msg) {
        this.data_msg = data_msg;
    }

    public Long getCod_dest() {
        return cod_dest;
    }

    public void setCod_dest(Long cod_dest) {
        this.cod_dest = cod_dest;
    }
    
    
    
    
}
