/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.controller;

import com.daw.spvpetromoc.dao.UsuarioDAO;
import com.daw.spvpetromoc.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nando Cortez
 */
@Controller
public class LoginController {

    UsuarioDAO dao = new UsuarioDAO();
    String msgErro = "DADOS INVALIDOS!!!";

    @GetMapping({"/", "/login"})
    public ModelAndView paginaLog(ModelAndView model) {
        model.setViewName("login");
        return model;
    }

    @PostMapping("/entrar")
    public ModelAndView efetuaLogin(HttpServletRequest req, HttpSession session, ModelAndView model, Model m) {
        String e = req.getParameter("log");
        String s = req.getParameter("pass");

        Usuario usu = dao.verifica(e, s);
        if (usu.getSenha_user() == null && usu.getSenha_user() == null) {
            usu.setSenha_user("");
            usu.setEmail_user("");
            m.addAttribute("msgErro", msgErro);
            model.setViewName("login");
        } else {
            if (usu.getSenha_user().equals(s) && usu.getEmail_user().equals(e)) {
                session.setAttribute("usu", usu);
                model.addObject("usu", usu);
                if (usu.getTipo_user().equals("Administrador")) {
                    model.setViewName("home");
                } else {
                    model.setViewName("homeTecnicos");
                }
            }
        }

        return model;
    }

    @GetMapping("/entrar")
    public ModelAndView entrar(HttpSession session, ModelAndView model) {
        if (session != null) {
            Usuario u = (Usuario) session.getAttribute("usu");
            if (u.getTipo_user().equals("Administrador")) {
                model.setViewName("home");
            } else {
                model.setViewName("homeTecnicos");
            }
        } else{
        model.setViewName("paginaErro");
        }
        return model;
    }

    @GetMapping("/logout")
    public ModelAndView sair(HttpSession session, ModelAndView model) {
        session.invalidate();
        model.setViewName("login");

        return model;
    }
}
