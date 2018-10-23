/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.controller;

import com.daw.spvpetromoc.dao.UsuarioDAO;
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
public class UserController {

    UsuarioDAO dao = new UsuarioDAO();

    @GetMapping("/form-usuario")
    public ModelAndView logar(ModelAndView model, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {

            model.setViewName("cad_user");
        }
        return model;
    }

    @PostMapping("/cadastro-usuario")
    public ModelAndView gravar(ModelAndView model, @ModelAttribute Usuario user, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            String mensagem = user.getNome_user() + " cadastrado com sucesso!";
            dao.salvar(user);
            List<Usuario> lista = dao.listar();
            model.addObject("mensagem", mensagem);
            model.addObject("lista", lista);
            model.setViewName("cad_user");
        }
        return model;
    }

    @GetMapping("/lista-usuario")

    public ModelAndView listar(ModelAndView model, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            List<Usuario> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("list_user");
        }
        return model;
    }

    @GetMapping("/remover-user")
    public ModelAndView apagar(ModelAndView model, @RequestParam Long id, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            dao.apagar(id);
            List<Usuario> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("list_user");
        }
        return model;
    }

    @GetMapping("/editar")
    public ModelAndView chamarEditar(ModelAndView model, @RequestParam Long id, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            List<Usuario> lista = dao.listar();
            if (id == null) {
                model.addObject("lista", lista);
                model.setViewName("list_user");
            } else {

                Usuario edit = dao.pesquisar(id);
                if (edit == null) {
                    model.addObject("lista", lista);
                    model.setViewName("list_user");
                }
                model.addObject("edit", edit);
                model.setViewName("atualizar_user");
            }
        }

        return model;
    }

    @PostMapping("/atualizar")
    public ModelAndView editar(ModelAndView model, @ModelAttribute Usuario user,HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            dao.editar(user);
            List<Usuario> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("list_user");
        }
        return model;
    }

}
