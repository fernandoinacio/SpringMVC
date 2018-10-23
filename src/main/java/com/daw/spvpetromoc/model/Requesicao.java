/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.model;

import java.io.Serializable;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nando Cortez
 */
@Entity
@Table(name = "tbl_requesicao")
public class Requesicao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_req", nullable = false)
    private Long cod_req;
    private String prov_destino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date data_partida;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date data_retorno;
    private String motivo;
    private String obs_req;
    private String status;
    private Long cod_dest;
    private Date data_req = new Date(System.currentTimeMillis());
    @OneToOne
    private Viatura vt;
    @ManyToOne
    private Usuario usu;
    @OneToOne
    private Motorista mt;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Mensagem> msgs_req = new ArrayList<Mensagem>();

    public Requesicao() {
    }

    public Long getCod_req() {
        return cod_req;
    }

    public void setCod_req(Long cod_req) {
        this.cod_req = cod_req;
    }

    public String getProv_destino() {
        return prov_destino;
    }

    public void setProv_destino(String prov_destino) {
        this.prov_destino = prov_destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Viatura getVt() {
        return vt;
    }

    public void setVt(Viatura vt) {
        this.vt = vt;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Motorista getMt() {
        return mt;
    }

    public void setMt(Motorista mt) {
        this.mt = mt;
    }

    public String getObs_req() {
        return obs_req;
    }

    public void setObs_req(String obs_req) {
        this.obs_req = obs_req;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_req() {
        return data_req;
    }

    public void setData_req(Date data_req) {
        this.data_req = data_req;
    }

    public List<Mensagem> getMsgs_req() {
        return msgs_req;
    }

    public void setMsgs_req(List<Mensagem> msgs_req) {
        this.msgs_req = msgs_req;
    }

    public Long getCod_dest() {
        return cod_dest;
    }

    public void setCod_dest(Long cod_dest) {
        this.cod_dest = cod_dest;
    }

    public java.util.Date getData_partida() {
        return data_partida;
    }

    public void setData_partida(java.util.Date data_partida) {
        this.data_partida = data_partida;
    }

    public java.util.Date getData_retorno() {
        return data_retorno;
    }

    public void setData_retorno(java.util.Date data_retorno) {
        this.data_retorno = data_retorno;
    }


}
