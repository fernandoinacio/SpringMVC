<%-- 
    Document   : login
    Created on : 1/out/2018, 15:57:53
    Author     : Nando Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="paginaErro.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="16x16" href="resources/assets/images/petroLG.png">
        <title>SPV-Petromoc | Login</title>

        <c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
        <style type="text/css">
            @IMPORT url("${path}/resources/css_/bootstrap.min.css");
            @IMPORT url("${path}/resources/css_/font-awesome.css");
            @IMPORT url("${path}/resources/css_/animate.css");
            @IMPORT url("${path}/resources/css_/style.css");
        </style>
    </head>

    <body class="gray-bg">

        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div>
                <div>

                    <h1 class="logo-name">SPV</h1>

                </div>
                <h3>Seja Bem-Vindo ao SPV</h3>

                <form class="m-t" role="form" action="entrar" method="POST" >
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="E-mail" name="log" required="">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Senha" name="pass" required="">
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

                    <a href="recu_senha"><small>Esqueceu-se da senha?</small></a>
                </form>
                <div class="alert alert-danger"><strong>${msgErro}</strong></div>
                <p class="m-t"> <small>Sistema de partilha de viaturas da petromoc &copy; 2018</small> </p>
            </div>
             
        </div>
        <script type="text/javascript" src="${path}/resources/js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="${path}/resources/js/bootstrap.min.js"></script>

    </body>

</html>