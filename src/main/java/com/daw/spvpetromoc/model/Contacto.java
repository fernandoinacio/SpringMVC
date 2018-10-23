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
@Table(name = "tbl_contacto")
public class Contacto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto", nullable = false) private Long cod_contacto;
    @NotEmpty @Size(min = 9) private String cell;

    public Contacto() {
    }

    public Long getCod_contacto() {
        return cod_contacto;
    }

    public void setCod_contacto(Long cod_contacto) {
        this.cod_contacto = cod_contacto;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

}
