/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.dao;

import com.daw.spvpetromoc.model.Usuario;
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
public class UsuarioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPV_PetromocPU");

    //Metodo para salvar o usuario no banco de dados
    public void salvar(Usuario user) {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if(!em.contains(user)){
            em.persist(user);
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

    //Metodo para editar o usuario no banco de dados
    public Usuario editar(Usuario user) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }
    //Metodo para encontrar o usuario no banco de dados

    public Usuario pesquisar(Long id) {
        EntityManager em = emf.createEntityManager();

        Usuario user = null;
        try {
            em.getTransaction().begin();
            user = em.find(Usuario.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }

    //Metodo para apagar o usuario no banco de dados
    public Usuario apagar(Long id) {

        EntityManager em = emf.createEntityManager();

        Usuario user = null;
        try {
            em.getTransaction().begin();
            user = em.find(Usuario.class, id);
            em.remove(user);
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
        return user;
    }

    public List<Usuario> listar() {
        EntityManager em = emf.createEntityManager();

        List<Usuario> lista = new ArrayList();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("select u from Usuario u inner join u.func f inner join u.func.dept d").getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }

    public Usuario verifica(String email, String senha) {
        EntityManager em = emf.createEntityManager();
        Usuario obj = new Usuario();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Usuario u where u.email_user =:email and u.senha_user =:senha");
            q.setParameter("email", email);
            q.setParameter("senha", senha);
            obj = (Usuario) q.getSingleResult();
            em.getTransaction().commit();
            
            if(obj==null){
                obj.setEmail_user("");
                obj.setSenha_user("");
            }
        } catch (Exception e) {
           if(em.getTransaction()!=null){
            if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
            }
          }
        } finally {
            em.close();
        }
        return obj;
    }
    
    public Usuario pesqDept(String dp,String user){
        EntityManager em = emf.createEntityManager();
        Usuario obj = null;
        
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Usuario u inner join u.func f inner join u.func.dept d where u.tipo_user =:user and d.nome_dept =:dp");
            q.setParameter("dp", dp);
            q.setParameter("user",user);
            obj = (Usuario) q.getSingleResult();
            em.getTransaction().commit();
            
    }catch(Exception e){
         Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
    }finally{
          em.close();
        }
        return obj;
    }
    
      public Usuario retornaPeloTipo(String tipo){
        EntityManager em = emf.createEntityManager();
        Usuario obj = new Usuario();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select u from Usuario u where u.tipo_user =:tipo");
            q.setParameter("tipo",tipo);
            obj = (Usuario) q.getSingleResult();
            em.getTransaction().commit();
            
    }catch(Exception e){
         Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            em.getTransaction().rollback();
    }finally{
          em.close();
        }
        return obj;
    }
}
