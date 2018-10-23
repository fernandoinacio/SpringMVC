/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.controller;

import com.daw.spvpetromoc.dao.MotoristaDAO;
import com.daw.spvpetromoc.model.Motorista;
import com.daw.spvpetromoc.model.Usuario;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nando Cortez
 */
@Controller
public class MotoristaController {

    MotoristaDAO dao = new MotoristaDAO();

    @GetMapping("/form-motorista")
    private ModelAndView mostrar(ModelAndView model,HttpSession session) {
          Usuario usu = (Usuario) session.getAttribute("usu");
        if(!usu.getTipo_user().equals("Administrador")){ 
            model.setViewName("autorizacao");
        }else{
        model.setViewName("cad_motorista");
        }
        return model;
    }

    @PostMapping("/cadastro-motorista")
    public ModelAndView cadastrar(ModelAndView model, @ModelAttribute Motorista mt,HttpSession session) {
          Usuario usu = (Usuario) session.getAttribute("usu");
        if(!usu.getTipo_user().equals("Administrador")){ 
            model.setViewName("autorizacao");
        }else{
        String mensagem =  mt.getNome_mt() + " cadastrado com sucesso!";
        List<Motorista> lista = dao.listar();
        dao.salvar(mt);
        model.addObject("mensagem",mensagem);
        model.addObject("lista", lista);
        model.setViewName("cad_motorista");
        }
        return model;
    }

    @GetMapping("/lista-motorista")
    public ModelAndView listar(ModelAndView model,HttpSession session) {
          Usuario usu = (Usuario) session.getAttribute("usu");
        if(!usu.getTipo_user().equals("Administrador")){ 
            model.setViewName("autorizacao");
        }else{
        List<Motorista> lista = dao.listar();
        model.addObject("lista", lista);
        model.setViewName("list_motoristas");
        }
        return model;
    }

    @GetMapping("/remover-motorista")
    public ModelAndView remover(ModelAndView model, @RequestParam Long id,HttpSession session) {
          Usuario usu = (Usuario) session.getAttribute("usu");
        if(!usu.getTipo_user().equals("Administrador")){ 
            model.setViewName("autorizacao");
        }else{
        dao.apagar(id);
        List<Motorista> lista = dao.listar();
        model.addObject("lista", lista);
        model.setViewName("list_motoristas");
        }
        return model;
    }

    @GetMapping("/editar-motorista")
    public ModelAndView chamarEditar(ModelAndView model, @RequestParam Long id,HttpSession session) {
          Usuario usu = (Usuario) session.getAttribute("usu");
        if(!usu.getTipo_user().equals("Administrador")){ 
            model.setViewName("autorizacao");
        }else{
        List<Motorista> lista = dao.listar();
        if (id == null) {
            model.addObject("lista", lista);
            model.setViewName("list_motoristas");
        } else {

            Motorista edit = dao.pesquisar(id);
            if (edit == null) {
                model.addObject("lista", lista);
                model.setViewName("list_motoristas");
            }
            model.addObject("edit", edit);
            model.setViewName("atualizar_motorista");
        }
        }
        return model;
    }

    @PostMapping("/atualizar-motorista")
    public ModelAndView editar(ModelAndView model, @ModelAttribute Motorista mt,HttpSession session) {
          Usuario usu = (Usuario) session.getAttribute("usu");
        if(!usu.getTipo_user().equals("Administrador")){ 
            model.setViewName("autorizacao");
        }else{

        dao.editar(mt);
        List<Motorista> lista = dao.listar();
        model.addObject("lista", lista);
        model.setViewName("list_user");
        }
        return model;
        
    }
}
