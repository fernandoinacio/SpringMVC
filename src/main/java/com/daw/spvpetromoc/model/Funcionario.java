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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nando Cortez
 */
@Entity
@Table(name = "tbl_funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_func", nullable = false)
    private Long cod_func;
    private String cargo_func;
    @OneToMany
    @JoinColumn(name = "fk_cell")
    private List<Contacto> cell_func;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_dept")
    private Departamento dept;

    public Funcionario() {
    }

    public Funcionario(String cargo_func, Departamento dept) {
        this.cargo_func = cargo_func;
        this.dept = dept;
    }
    

    public Long getCod_func() {
        return cod_func;
    }

    public void setCod_func(Long cod_func) {
        this.cod_func = cod_func;
    }

    public String getCargo_func() {
        return cargo_func;
    }

    public void setCargo_func(String cargo_func) {
        this.cargo_func = cargo_func;
    }

    public Departamento getDept() {
        return dept;
    }

    public void setDept(Departamento dept) {
        this.dept = dept;
    }

    public List<Contacto> getCell_func() {
        return cell_func;
    }

    public void setCell_func(List<Contacto> cell_func) {
        this.cell_func = cell_func;
    }

}
