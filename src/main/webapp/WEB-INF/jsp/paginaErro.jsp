<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<%@include  file="validar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" sizes="16x16" href="resources/assets/images/petroLG.png">
        <title>Erro</title>

        <link href="resources/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container text-center">
            <div class="col-md-6 center-block">

                <h2 class="display-1">Ops! Ocorreu um erro!</h2>
                
                
                <%=exception%>

                <p class="text-muted">Por favor contacte a equipe de IT pelos contactos</p>
                <p><strong>+258 84 773 7291</strong>: Valdemiro Senda</p>
                <p><strong>valdemirosenda@gmail.com</strong>

                <a href="/SPVPetromoc/entrar">Voltar</a>
            </div>
        </div>
    </body>
</html>
