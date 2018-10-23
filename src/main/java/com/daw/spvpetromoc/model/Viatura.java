/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Nando Cortez
 */
@Entity
@Table(name = "tbl_viatura")
public class Viatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viatura", nullable = false)
    private Long cod_vt;
    @NotEmpty
    private String marca;
    private String modelo;
    private String tipo_combustivel;
    private String cor;
    private int nr_assentos;
    @Temporal(TemporalType.DATE)
    private Date data_aquisicao;
    private int ano_fabrico;
    private String tipo_vt;
    private String matricula;
    private String obs_vt;

    public Long getCod_vt() {
        return cod_vt;
    }

    public void setCod_vt(Long cod_vt) {
        this.cod_vt = cod_vt;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNr_assentos() {
        return nr_assentos;
    }

    public void setNr_assentos(int nr_assentos) {
        this.nr_assentos = nr_assentos;
    }


    public int getAno_fabrico() {
        return ano_fabrico;
    }

    public void setAno_fabrico(int ano_fabrico) {
        this.ano_fabrico = ano_fabrico;
    }

    public String getTipo_vt() {
        return tipo_vt;
    }

    public void setTipo_vt(String tipo_vt) {
        this.tipo_vt = tipo_vt;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getObs_vt() {
        return obs_vt;
    }

    public void setObs_vt(String obs_vt) {
        this.obs_vt = obs_vt;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }
    
    


}
