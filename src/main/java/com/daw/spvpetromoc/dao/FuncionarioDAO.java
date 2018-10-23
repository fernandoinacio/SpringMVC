/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.dao;

import com.daw.spvpetromoc.model.Departamento;
import com.daw.spvpetromoc.model.Funcionario;
import com.daw.spvpetromoc.model.Motorista;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nando Cortez
 */
public class FuncionarioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPV_PetromocPU");

    public void salvar(Funcionario func) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(func);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Funcionario editar(Funcionario func) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            if (func.getCod_func() == null) {
                em.persist(func);
            } else {
                em.merge(func);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return func;
    }

    public Funcionario pesquisar(Long id) {
        EntityManager em = emf.createEntityManager();

        Funcionario func = null;

        try {
            em.getTransaction().begin();
            func = em.find(Funcionario.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return func;
    }

    public Funcionario apagar(Long id) {
        EntityManager em = emf.createEntityManager();

        Funcionario func = null;
        try {
            em.getTransaction().begin();
            func = em.find(Funcionario.class, id);
            em.remove(func);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return func;
    }

    public List<Departamento> listarDept() {

        EntityManager em = emf.createEntityManager();

        List<Departamento> list = new ArrayList<>();

        try {
            em.getTransaction().begin();
            list = em.createQuery("from Departamento d").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
    }
    
     public List<Motorista> listarMotorista() {

        EntityManager em = emf.createEntityManager();

        List<Motorista> list = new ArrayList<>();

        try {
            em.getTransaction().begin();
            list = em.createQuery("from Motorista d").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
    }

}
