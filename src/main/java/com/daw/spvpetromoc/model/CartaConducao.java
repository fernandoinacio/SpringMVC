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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
/**
 *
 * @author Nando Cortez
 */
@Entity
@Table(name = "tbl_carta")
public class CartaConducao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta", nullable = false) private Long cod_carta;
    @NotEmpty
    @Size(max =10 ) private String nr_carta;
    @NotEmpty private String tipo_carta;
    @NotEmpty private String local_emissao;
    @NotEmpty private String validade;

    public Long getCod_carta() {
        return cod_carta;
    }

    public void setCod_carta(Long cod_carta) {
        this.cod_carta = cod_carta;
    }

    public String getNr_carta() {
        return nr_carta;
    }

    public void setNr_carta(String nr_carta) {
        this.nr_carta = nr_carta;
    }

    public String getTipo_carta() {
        return tipo_carta;
    }

    public void setTipo_carta(String tipo_carta) {
        this.tipo_carta = tipo_carta;
    }

    public String getLocal_emissao() {
        return local_emissao;
    }

    public void setLocal_emissao(String local_emissao) {
        this.local_emissao = local_emissao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }


    
}
