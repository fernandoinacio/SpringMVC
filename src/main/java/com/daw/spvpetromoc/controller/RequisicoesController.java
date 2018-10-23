/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.controller;

import com.daw.spvpetromoc.dao.FuncionarioDAO;
import com.daw.spvpetromoc.dao.MotoristaDAO;
import com.daw.spvpetromoc.dao.RequesicaoDAO;
import com.daw.spvpetromoc.dao.UsuarioDAO;
import com.daw.spvpetromoc.dao.ViaturaDAO;
import com.daw.spvpetromoc.model.Mensagem;
import com.daw.spvpetromoc.model.Motorista;
import com.daw.spvpetromoc.model.Requesicao;
import com.daw.spvpetromoc.model.Usuario;
import com.daw.spvpetromoc.model.Viatura;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
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
public class RequisicoesController {

    RequesicaoDAO dao = new RequesicaoDAO();
    UsuarioDAO daoUser = new UsuarioDAO();
    ViaturaDAO daoVt = new ViaturaDAO();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @GetMapping("/requesicoes")
    public ModelAndView mostrar(ModelAndView model, HttpSession session, @RequestParam Long id) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        if (!usuario.getTipo_user().equals("Administrador")) {

            if (id == null) {
                List<Viatura> lista = daoVt.listar();
                model.addObject("lista", lista);
                model.setViewName("disponibilidadeTecnicos");
                return model;
            } else {
                Usuario u = (Usuario) session.getAttribute("usu");
                Usuario var = daoUser.pesqDept(u.getFunc().getDept().getNome_dept(), "Usuario");
                Viatura vt = daoVt.pesquisar(id);
                session.setAttribute("vt", vt);
                model.addObject("var", var);
                model.setViewName("requesicoes_viewTecnicos");
            }
        } else {

            if (id == null) {
                List<Viatura> lista = daoVt.listar();
                model.addObject("lista", lista);
                model.setViewName("disponibilidade");
                return model;
            } else {
                Usuario u = (Usuario) session.getAttribute("usu");
                Usuario var = daoUser.pesqDept(u.getFunc().getDept().getNome_dept(), "Usuario");
                Viatura vt = daoVt.pesquisar(id);
                model.addObject("vt", vt);
                model.addObject("var", var);
                model.setViewName("requesicoes_view");
            }
        }
        return model;
    }

    @PostMapping("/requisitar")
    public ModelAndView gravarReq(ModelAndView model, @ModelAttribute Requesicao req, HttpSession session, HttpServletRequest request) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        Viatura vt = (Viatura) session.getAttribute("vt");

        if (usuario.getTipo_user().equals("Administrador")) {
            Mensagem msg = new Mensagem();
            Usuario var = daoUser.retornaPeloTipo("Administrador");
            msg.setCod_dest(var.getCod_user());
            msg.setConteudo_msg(request.getParameter("motorista"));
            msg.setStatus("Validada");
            msg.setTipo_msg("Valida");
            msg.setTitulo_msg("Envio de requesicao");
            req.setCod_dest(var.getCod_user());
            req.getMsgs_req().add(msg);
            req.setCod_dest(var.getCod_user());
            req.setStatus("Validado");
            req.setVt(vt);
            req.setUsu(usuario);
            df.format(req.getData_partida());
            Requesicao r = dao.listarImpedidos(req.getVt().getCod_vt(), req.getData_partida(), "Aceite");
            df.format(r.getData_partida());
            if (r != null) {

                if (req.getData_partida().compareTo(r.getData_partida()) == 0) {
                    model.addObject("mensagem", "A viatura selecionada esta indisponivel para a data que deseja selecione outra por favor");
                    model.setViewName("disponibilidade");
                } else {
                    dao.salvar(req);
                    model.addObject("mensagem", "Pedido feito com sucesso");
                    model.setViewName("requesicoes_view");
                }
            }
            dao.salvar(req);
            model.addObject("mensagem", "Pedido feito com sucesso");
            model.setViewName("requesicoes_view");

        } else if (usuario.getTipo_user().equals("Usuario")) {
            Mensagem msg = new Mensagem();
            Usuario var = daoUser.retornaPeloTipo("Administrador");
            msg.setCod_dest(var.getCod_user());
            msg.setConteudo_msg(request.getParameter("motorista"));
            msg.setTipo_msg("Pedido");
            msg.setStatus("Pendente");
            msg.setTitulo_msg("Envio de requesicao");
            req.setCod_dest(var.getCod_user());
            req.getMsgs_req().add(msg);
            req.setCod_dest(var.getCod_user());
            req.setStatus("Enviado");
            req.setVt(vt);
            req.setUsu(usuario);
            Requesicao r = dao.listarImpedidos(req.getVt().getCod_vt(), req.getData_partida(), "Aceite");
            if (r != null) {

                if (!req.getData_partida().equals(r.getData_partida())) {
                    dao.salvar(req);
                    model.addObject("mensagem", "Pedido feito com sucesso");
                    model.setViewName("requesicoes_viewTecnicos");
                } else {
                    model.addObject("mensagem", "A viatura selecionada esta indisponivel para a data que deseja selecione outra por favor");
                    model.setViewName("disponibilidadeTecnicos");
                }
            }
            dao.salvar(req);
            model.addObject("mensagem", "Pedido feito com sucesso");
            model.setViewName("requesicoes_viewTecnicos");
        } else {
            Mensagem msg = new Mensagem();
            Usuario var = daoUser.pesqDept(usuario.getFunc().getDept().getNome_dept(), "Usuario");
            msg.setCod_dest(var.getCod_user());
            msg.setConteudo_msg(request.getParameter("motorista"));
            msg.setTipo_msg("Pedido");
            msg.setStatus("Pendente");
            msg.setTitulo_msg("Envio de requesicao");
            req.setCod_dest(var.getCod_user());
            req.getMsgs_req().add(msg);
            req.setCod_dest(var.getCod_user());
            req.setStatus("Enviado");
            req.setVt(vt);
            req.setUsu(usuario);
            Requesicao r = dao.listarImpedidos2(req.getVt().getCod_vt(), req.getData_partida(),req.getData_retorno(), "Aceite");
            if (r != null) {
                    model.addObject("mensagem", "A viatura selecionada esta indisponivel para a data que deseja selecione outra por favor");
                    List<Viatura> lista = daoVt.listar();
                    model.addObject("lista", lista);
                    model.setViewName("disponibilidadeTecnicos");
            } else {
                dao.salvar(req);
                model.addObject("mensagem", "Pedido feito com sucesso");
                model.setViewName("requesicoes_viewTecnicos");
            }
        }
        return model;
    }

    @GetMapping("/inbox")
    public ModelAndView mostrarReq(ModelAndView model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        if (usuario.getTipo_user().equals("Administrador")) {
            List<Requesicao> saidasAdmin = dao.minhasMsgsSaidasAdmin("Resposta");
            List<Requesicao> saidas = dao.minhasMsgsSaidas("Valida", usuario.getCod_user(), usuario.getCod_user());
            List<Requesicao> entradas = dao.minhasMsgsEntradas("Valida", usuario.getCod_user());
            List<Requesicao> respostas = dao.minhasMsgsEntradas("Resposta", usuario.getCod_user());

            List<Requesicao> lista = dao.listar("Enviado", usuario.getCod_user());
            List<Requesicao> recebidos = dao.listarReqs("Enviado", usuario.getCod_user());
            List<Requesicao> aceites = dao.listarReqs("Validado", usuario.getCod_user());

            model.addObject("saidasAdmin", saidasAdmin);
            model.addObject("saidas", saidas);
            model.addObject("entradas", entradas);

            model.addObject("aceites", aceites);
            model.addObject("recebidos", recebidos);
            model.addObject("lista", lista);
            model.setViewName("caixa_msgs");

        } else if (usuario.getTipo_user().equals("Usuario")) {
            Usuario var = daoUser.retornaPeloTipo("Administrador");
            List<Requesicao> lista = dao.listar("Enviado", usuario.getCod_user());
            List<Requesicao> recebidos = dao.listarReqs("Enviado", usuario.getCod_user());
            List<Requesicao> aceites = dao.listarReqs("Aceite", usuario.getCod_user());
            List<Requesicao> pedidos = dao.minhasMsgsEntradas("Pedido", usuario.getCod_user());
            List<Requesicao> entradas = dao.minhasMsgsEntradas("Resposta", usuario.getCod_user());
            List<Requesicao> saidas = dao.minhasMsgsSaidas("Pedido", var.getCod_user(), usuario.getCod_user());

            model.addObject("pedidos", pedidos);
            model.addObject("entradas", entradas);
            model.addObject("saidas", saidas);
            model.addObject("aceites", aceites);
            model.addObject("recebidos", recebidos);
            model.addObject("lista", lista);
            model.setViewName("caixa_msgsTecnico");

        } else {
            Usuario var = daoUser.pesqDept(usuario.getFunc().getDept().getNome_dept(), "Usuario");
            List<Requesicao> lista = dao.listar("Enviado", usuario.getCod_user());
            List<Requesicao> recebidos = dao.listarReqs("Enviado", usuario.getCod_user());
            List<Requesicao> aceites = dao.listarReqs("Aceite", usuario.getCod_user());
            List<Requesicao> entradas = dao.minhasMsgsEntradas("Resposta", usuario.getCod_user());
            List<Requesicao> saidas = dao.minhasMsgsSaidas("Pedido", var.getCod_user(), usuario.getCod_user());

            model.addObject("entradas", entradas);
            model.addObject("saidas", saidas);
            model.addObject("aceites", aceites);
            model.addObject("recebidos", recebidos);
            model.addObject("lista", lista);
            model.setViewName("caixa_msgsTecnico");
        }
        return model;
    }

    @GetMapping("/mensagem")
    public ModelAndView responder(ModelAndView model, @RequestParam("id") Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        Requesicao req = dao.pesquisar(id);

        Usuario dest = daoUser.pesquisar(req.getCod_dest());
        if (usuario.getTipo_user().equals("Usuario simples")) {

            model.addObject("dest", dest);
            model.addObject("req", req);
            model.setViewName("msgs");
        } else if (usuario.getTipo_user().equals("Usuario")) {
            model.addObject("dest", dest);
            model.addObject("req", req);
            model.setViewName("msgsAdm");
        } else {
            FuncionarioDAO daoMt = new FuncionarioDAO();
            List<Motorista> motoristas = daoMt.listarMotorista();
            model.addObject("motoristas", motoristas);
            model.addObject("dest", dest);
            model.addObject("req", req);
            session.setAttribute("req", req);
            model.setViewName("msgAdministrador");
        }
        return model;
    }

    @GetMapping("/validar")
    public ModelAndView validar(HttpSession session, ModelAndView model, @RequestParam Long id) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        Mensagem m = new Mensagem();
        Usuario u = (Usuario) session.getAttribute("usu");
        Usuario adm = daoUser.retornaPeloTipo("Administrador");
        Requesicao req = dao.pesquisar(id);

        m.setCod_dest(adm.getCod_user());
        m.setConteudo_msg("Requesicao visuaizada e aprovada pelo gestor " + u.getNome_user() + " -" + u.getFunc().getDept().getNome_dept());
        m.setTitulo_msg("Pedido de alocacao de viatura");
        m.setStatus("Validada");
        m.setTipo_msg("Valida");
        m.setData_msg(new java.sql.Date(System.currentTimeMillis()));
        Hibernate.initialize(req.getMsgs_req());
        req.setCod_dest(adm.getCod_user());
        req.getMsgs_req().add(m);
        req.setStatus("Validado");
        dao.editar(req);
        Usuario var = daoUser.retornaPeloTipo("Administrador");
        List<Requesicao> lista = dao.listar("Enviado", usuario.getCod_user());
        List<Requesicao> recebidos = dao.listarReqs("Enviado", usuario.getCod_user());
        List<Requesicao> aceites = dao.listarReqs("Aceite", usuario.getCod_user());
        List<Requesicao> pedidos = dao.minhasMsgsEntradas("Pedido", usuario.getCod_user());
        List<Requesicao> entradas = dao.minhasMsgsEntradas("Resposta", usuario.getCod_user());
        List<Requesicao> saidas = dao.minhasMsgsSaidas("Pedido", var.getCod_user(), usuario.getCod_user());

        model.addObject("pedidos", pedidos);
        model.addObject("entradas", entradas);
        model.addObject("saidas", saidas);
        model.addObject("aceites", aceites);
        model.addObject("recebidos", recebidos);
        model.addObject("lista", lista);
        model.setViewName("caixa_msgsTecnico");
        return model;
    }

    @GetMapping("/validacao")
    public ModelAndView validar(HttpSession session, ModelAndView model, @RequestParam Long id, HttpServletRequest request) {
        Requesicao req = dao.pesquisar(id);
        MotoristaDAO daoMt = new MotoristaDAO();
        List<Motorista> motoristas = daoMt.listar();
        model.addObject("motoristas", motoristas);
        model.addObject("req", req);
        model.setViewName("alocar");
        return model;
    }

    @PostMapping("/alocar")
    public ModelAndView alocar(HttpSession session, ModelAndView model, @RequestParam Long id, HttpServletRequest request) {
        Usuario usuario = (Usuario) session.getAttribute("usu");
        MotoristaDAO daoMt = new MotoristaDAO();
        Motorista mt = daoMt.pesquisar(Long.parseLong(request.getParameter("codMot")));
        Requesicao req = dao.pesquisar(id);
        Usuario adm = req.getUsu();
        Mensagem val = new Mensagem();
        val.setCod_dest(adm.getCod_user());
        val.setConteudo_msg(request.getParameter("resposta"));
        val.setTitulo_msg(request.getParameter("titulo_msg"));
        val.setStatus("Aceite");
        val.setTipo_msg("Resposta");
        val.setData_msg(new java.sql.Date(System.currentTimeMillis()));
        req.setMt(mt);
        req.setCod_dest(adm.getCod_user());
        req.getMsgs_req().add(val);
        req.setStatus("Aceite");
        dao.editar(req);
        List<Requesicao> saidasAdmin = dao.minhasMsgsSaidasAdmin("Resposta");
        List<Requesicao> saidas = dao.minhasMsgsSaidas("Valida", usuario.getCod_user(), usuario.getCod_user());
        List<Requesicao> entradas = dao.minhasMsgsEntradas("Valida", usuario.getCod_user());
        List<Requesicao> respostas = dao.minhasMsgsEntradas("Resposta", usuario.getCod_user());

        List<Requesicao> lista = dao.listar("Enviado", usuario.getCod_user());
        List<Requesicao> recebidos = dao.listarReqs("Enviado", usuario.getCod_user());
        List<Requesicao> aceites = dao.listarReqs("Validado", usuario.getCod_user());

        model.addObject("saidasAdmin", saidasAdmin);
        model.addObject("saidas", saidas);
        model.addObject("entradas", entradas);

        model.addObject("aceites", aceites);
        model.addObject("recebidos", recebidos);
        model.addObject("lista", lista);
        model.setViewName("caixa_msgs");
        return model;
    }

}
