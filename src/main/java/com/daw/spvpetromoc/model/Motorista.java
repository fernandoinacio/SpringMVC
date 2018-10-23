/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Nando Cortez
 */
@Entity
@Table(name = "tbl_motorista")
public class Motorista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motorista", nullable = false)
    private Long cod_mt;
    @NotEmpty
    @Size(min = 8)
    private String nome_mt;
    @NotEmpty
    private String sexo_mt;
    private String data_nasc_mt;
    private String email_mt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_carta")
    private CartaConducao carta;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cell")
    private List<Contacto> cell_mt;

    public Motorista() {
    }

    public Long getCod_mt() {
        return cod_mt;
    }

    public void setCod_mt(Long cod_mt) {
        this.cod_mt = cod_mt;
    }

    public String getNome_mt() {
        return nome_mt;
    }

    public void setNome_mt(String nome_mt) {
        this.nome_mt = nome_mt;
    }

    public String getSexo_mt() {
        return sexo_mt;
    }

    public void setSexo_mt(String sexo_mt) {
        this.sexo_mt = sexo_mt;
    }

    public String getData_nasc_mt() {
        return data_nasc_mt;
    }

    public void setData_nasc_mt(String data_nasc_mt) {
        this.data_nasc_mt = data_nasc_mt;
    }

    public String getEmail_mt() {
        return email_mt;
    }

    public void setEmail_mt(String email_mt) {
        this.email_mt = email_mt;
    }

    public CartaConducao getCarta() {
        return carta;
    }

    public void setCarta(CartaConducao carta) {
        this.carta = carta;
    }

    public List<Contacto> getCell_mt() {
        return cell_mt;
    }

    public void setCell_mt(List<Contacto> cell_mt) {
        this.cell_mt = cell_mt;
    }

    
}
