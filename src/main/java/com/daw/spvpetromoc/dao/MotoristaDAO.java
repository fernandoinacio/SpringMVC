/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.dao;

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
public class MotoristaDAO {
    
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPV_PetromocPU");
    
    public void salvar(Motorista mt){
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(mt);
            em.getTransaction().commit();
            
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        }finally{
            em.close();       
        }      
    }
    
       public Motorista editar(Motorista mt){
                  EntityManager em = emf.createEntityManager();

           
           try{
               em.getTransaction().begin();
               if(mt.getCod_mt()==null){
                   em.persist(mt);
               }else{
                   em.merge(mt);
               }
               em.getTransaction().commit();
           }catch(Exception e){
                 Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback(); 
           }finally{
               em.close();
           }
           return mt;
       }
       
       public Motorista pesquisar(Long id){
                   EntityManager em = emf.createEntityManager();

           
           Motorista mt = null;
           
           try{
               em.getTransaction().begin();
               mt= em.find(Motorista.class,id);
               em.getTransaction().commit();
           }catch(Exception e){
               Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
               em.getTransaction().rollback();
           }finally{
               em.close();
           }
           return mt;
       }
           
       public Motorista apagar(Long id){
                   EntityManager em = emf.createEntityManager();

           
           Motorista mt= null;
           try{
               em.getTransaction().begin();
               mt= em.find(Motorista.class, id);
               em.remove(mt);
               em.getTransaction().commit();
           }catch(Exception e){
               Logger.getLogger(getClass().getName()).log(Level.SEVERE, "",e);
               em.getTransaction().rollback();
           }finally{
               em.close();
           }
           return mt;
       }
       
       public List<Motorista> listar(){
                   EntityManager em = emf.createEntityManager();

           
           List<Motorista> lista = new ArrayList();
           try{
               em.getTransaction().begin();
               lista= em.createQuery("select m from Motorista m inner join m.carta c").getResultList();
               em.getTransaction().commit();
               
           }catch(Exception e){
               Logger.getLogger(getClass().getName()).log(Level.SEVERE, "",e);
               em.getTransaction().rollback();
           }finally{
               em.close();
           }
           return lista;
       }
    
    }
    

