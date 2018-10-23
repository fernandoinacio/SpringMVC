/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.controller;

import com.daw.spvpetromoc.dao.RequesicaoDAO;
import com.daw.spvpetromoc.dao.ViaturaDAO;
import com.daw.spvpetromoc.model.Requesicao;
import com.daw.spvpetromoc.model.Usuario;
import com.daw.spvpetromoc.model.Viatura;
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
public class ViaturaController {

    ViaturaDAO dao = new ViaturaDAO();
    RequesicaoDAO daoReq = new RequesicaoDAO();

    @GetMapping("/form-viatura")
    public ModelAndView start(ModelAndView model, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            model.setViewName("cad_viatura");
        }
        return model;
    }

    @PostMapping("/cadastro-viatura")
    public ModelAndView gravarVt(ModelAndView model, @ModelAttribute Viatura vt, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            String mensagem = vt.getMarca() + " " + vt.getModelo() + " cadastrado com sucesso!";
            dao.salvar(vt);
            List<Viatura> lista = dao.listar();
            model.addObject("mesnagem", mensagem);
            model.addObject("lista", lista);
            model.setViewName("cad_viatura");
        }
        return model;
    }

    @GetMapping("/lista-viatura")
    public ModelAndView listar(ModelAndView model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        if (!usuario.getTipo_user().equals("Administrador")) {
            List<Viatura> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("disponibilidadeTecnicos");
        } else {
            List<Viatura> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("disponibilidade");
        }
        return model;
    }
    
    
    @GetMapping("/listagem")
    public ModelAndView listarVt(ModelAndView model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        if (!usuario.getTipo_user().equals("Administrador")) {
           model.setViewName("autorizacao");
        } else {
            List<Viatura> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("viaturasList");
        }
        return model;
    }

    @GetMapping("/disponivel")
    public ModelAndView lista(ModelAndView model, HttpSession session) {
        List<Requesicao> lista = daoReq.listarIndisponiveis("Aceite");
        List<Requesicao> listaDispo = daoReq.listarDisponiveis("Aceite");
        model.addObject("lista", lista);
        model.addObject("listaDispo", listaDispo);
        model.setViewName("listaViaturas");
        return model;
    }
    
       @GetMapping("/remover-viatura")
    public ModelAndView apagar(ModelAndView model, @RequestParam Long id, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            dao.apagar(id);
            List<Viatura> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("viaturasList");
        }
        return model;
    }

    @GetMapping("/editar-viatura")
    public ModelAndView chamarEditar(ModelAndView model, @RequestParam Long id, HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            List<Viatura> lista = dao.listar();
            if (id == null) {
                model.addObject("lista", lista);
                model.setViewName("viaturasList");
            } else {

                Viatura edit = dao.pesquisar(id);
                if (edit == null) {
                    model.addObject("lista", lista);
                    model.setViewName("viaturasList");
                }
                model.addObject("edit", edit);
                model.setViewName("atualizar_viatura");
            }
        }

        return model;
    }

    @PostMapping("/atualizar-viatura")
    public ModelAndView editar(ModelAndView model, @ModelAttribute Viatura vt,HttpSession session) {
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (!usu.getTipo_user().equals("Administrador")) {
            model.setViewName("autorizacao");
        } else {
            dao.editar(vt);
            List<Viatura> lista = dao.listar();
            model.addObject("lista", lista);
            model.setViewName("viaturasList");
        }
        return model;
    }

}
