/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.dao;

import com.daw.spvpetromoc.model.Viatura;
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
public class ViaturaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPV_PetromocPU");

    public void salvar(Viatura vt) {
        EntityManager em = emf.createEntityManager();
try {
            em.getTransaction().begin();
            if(!em.contains(vt)){
            em.persist(vt);
            em.flush();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
          if(em.getTransaction()!=null){
            if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
            }
          }
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
        } finally {
            em.close();
        }
    }

    public Viatura editar(Viatura vt) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            if (vt.getCod_vt() == null) {
                em.persist(vt);
            } else {
                em.merge(vt);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return vt;
    }

    public Viatura pesquisar(Long id) {
        EntityManager em = emf.createEntityManager();

        Viatura vt = null;

        try {
            em.getTransaction().begin();
            vt = em.find(Viatura.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return vt;
    }

    public Viatura apagar(Long id) {
        EntityManager em = emf.createEntityManager();

        Viatura dept = null;
        try {
            em.getTransaction().begin();
            dept = em.find(Viatura.class, id);
            em.remove(dept);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return dept;
    }

    public List<Viatura> listar() {
        EntityManager em = emf.createEntityManager();

        List<Viatura> lista = new ArrayList();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("from Viatura").getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

}
