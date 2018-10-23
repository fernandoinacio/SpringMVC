/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
@Table(name = "tbl_usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long cod_user;
    @NotEmpty
    @Size(min = 10)
    private String nome_user;
    @Size(min = 10)
    private String email_user;
    @Size(min = 6)
    private String senha_user;
    private String confSenha;
    private String tipo_user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_func")
    private Funcionario func;
    @OneToMany(mappedBy = "usu")
    private List<Requesicao> reqs;

    //String senha = Criptografia.criptografar(senha_user); 
    public Usuario() {

    }

    public Long getCod_user() {
        return cod_user;
    }

    public void setCod_user(Long cod_user) {
        this.cod_user = cod_user;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getSenha_user() {
        return senha_user;
    }

    public void setSenha_user(String senha_user) {
        this.senha_user = senha_user;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public List<Requesicao> getReqs() {
        return reqs;
    }

    public void setReqs(List<Requesicao> reqs) {
        this.reqs = reqs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nome_user);
        hash = 19 * hash + Objects.hashCode(this.senha_user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome_user, other.nome_user)) {
            return false;
        }
        if (!Objects.equals(this.senha_user, other.senha_user)) {
            return false;
        }
        return true;
    }

}
