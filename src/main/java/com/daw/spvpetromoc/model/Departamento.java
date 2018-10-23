/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.model;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "tbl_departamento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dept", nullable = false)
    private Long cod_dept;
    private String nome_dept;
 

    public Departamento() {
    }

    public Long getCod_dept() {
        return cod_dept;
    }

    public void setCod_dept(Long cod_dept) {
        this.cod_dept = cod_dept;
    }

    public String getNome_dept() {
        return nome_dept;
    }

    public void setNome_dept(String nome_dept) {
        this.nome_dept = nome_dept;
    }

}
