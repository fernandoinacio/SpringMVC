/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.dao;

import com.daw.spvpetromoc.model.Requesicao;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Nando Cortez
 */
public class RequesicaoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPV_PetromocPU");

    public void salvar(Requesicao req) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(req);
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Requesicao editar(Requesicao req) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            if (req.getCod_req() == null) {
                em.persist(req);
            } else {
                em.merge(req);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return req;
    }

    public Requesicao pesquisar(Long id) {
        EntityManager em = emf.createEntityManager();

        Requesicao req = null;

        try {
            em.getTransaction().begin();
            req = em.find(Requesicao.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return req;
    }

    public Requesicao apagar(Long id) {
        EntityManager em = emf.createEntityManager();

        Requesicao req = null;
        try {
            em.getTransaction().begin();
            req = em.find(Requesicao.class, id);
            em.remove(req);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return req;
    }

    public List<Requesicao> requiEntrada(Long id) {
        EntityManager em = emf.createEntityManager();
        List<Requesicao> list = new ArrayList<>();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select r from Requesicao r where r.ref_req =:id");
            q.setParameter("id", id);
            list = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();

        }
        return list;
    }

    public List<Requesicao> listar(String status, Long id) {
        EntityManager em = emf.createEntityManager();

        List<Requesicao> lista = new ArrayList();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.vt v inner join u.usu d where u.status =:status and d.cod_user =:id");
            q.setParameter("status", status);
            q.setParameter("id", id);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public List<Requesicao> listarReqs(String status, Long id) {
        EntityManager em = emf.createEntityManager();

        List<Requesicao> lista = new ArrayList();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u where u.cod_dest =:id and u.status =:status");
            q.setParameter("status", status);
            q.setParameter("id", id);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public Requesicao listarImpedidos(Long id, java.util.Date data, String status) {
        EntityManager em = emf.createEntityManager();

        Requesicao lista = null;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.vt v where v.cod_vt =:id and u.data_partida =:data and u.status =:status");
            q.setParameter("data", data);
            q.setParameter("status", status);
            q.setParameter("id", id);
            lista = (Requesicao) q.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public Requesicao listarImpedidos2(Long id, java.util.Date dataInicio, java.util.Date dataFim, String status) {
        EntityManager em = emf.createEntityManager();

        Requesicao lista = null;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.vt v where v.cod_vt =:id and u.data_partida >=:dataInicio and u.data_retorno <=:dataFim and u.status =:status");
            q.setParameter("dataInicio", dataInicio);
            q.setParameter("dataFim", dataFim);
            q.setParameter("status", status);
            q.setParameter("id", id);
            lista = (Requesicao) q.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public List<Requesicao> minhasMsgsEntradas(String tipo, Long id) {
        EntityManager em = emf.createEntityManager();

        List<Requesicao> lista = new ArrayList<>();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.msgs_req v where v.tipo_msg =:tipo and v.cod_dest =:id");
            q.setParameter("tipo", tipo);
            q.setParameter("id", id);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public List<Requesicao> minhasMsgsSaidas(String tipo, Long idGestor, Long idUsu) {
        EntityManager em = emf.createEntityManager();

        List<Requesicao> lista = new ArrayList<>();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.msgs_req v inner join u.usu w where v.tipo_msg =:tipo and v.cod_dest =:idGestor and w.cod_user =:idUsu");
            q.setParameter("tipo", tipo);
            q.setParameter("idGestor", idGestor);
            q.setParameter("idUsu", idUsu);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public List<Requesicao> minhasMsgsSaidasAdmin(String tipo) {
        EntityManager em = emf.createEntityManager();

        List<Requesicao> lista = new ArrayList<>();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.msgs_req v where v.tipo_msg =:tipo");
            q.setParameter("tipo", tipo);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public List<Requesicao> listarIndisponiveis(String status) {
        EntityManager em = emf.createEntityManager();

        List<Requesicao> lista = new ArrayList<>();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.vt v where u.data_partida >=:CURRENT_DATE and u.data_retorno <=:CURRENT_DATE and u.status =:status");
            q.setParameter("status", status);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }
    
        public List<Requesicao> listarDisponiveis(String status) {
        EntityManager em = emf.createEntityManager();

        List<Requesicao> lista = new ArrayList<>();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Requesicao u inner join u.vt v where u.status !=:status");
            q.setParameter("status", status);
            lista = q.getResultList();
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
