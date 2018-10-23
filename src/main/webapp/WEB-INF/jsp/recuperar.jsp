<%-- 
    Document   : recuperar
    Created on : 2/out/2018, 18:24:49
    Author     : Nando Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="paginaErro.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Forgot password</title>

    <link href="css_/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome_/css/font-awesome.css" rel="stylesheet">

    <link href="css_/animate.css" rel="stylesheet">
    <link href="css_/style.css" rel="stylesheet">
    
     <c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
        <style type="text/css">
            @IMPORT url("${path}/resources/css_/bootstrap.min.css");
            @IMPORT url("${path}/resources/css/font-awesome.css");
            @IMPORT url("${path}/resources/css_/animate.css");
            @IMPORT url("${path}/resources/css_/style.css");
        </style>

</head>

<body class="gray-bg">

    <div class="passwordBox animated fadeInDown">
        <div class="row">

            <div class="col-md-12">
                <div class="ibox-content">

                    <h2 class="font-bold">Esqueceu-se da senha</h2>

                    <p>
                        Digite o seu email para alterar a senha.
                       
                    </p>

                    <div class="row">

                        <div class="col-lg-12">
                            <form class="m-t" role="form" action="index.html">
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Endereço electrónico " required="">
                                </div>

                                <button type="submit" class="btn btn-primary block full-width m-b">Envie a nova senha</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div class="col-md-6">
                Copyright David Jr.
            </div>
            <div class="col-md-6 text-right">
               <small>© 2018</small>
            </div>
        </div>
    </div>

</body>

</html>

