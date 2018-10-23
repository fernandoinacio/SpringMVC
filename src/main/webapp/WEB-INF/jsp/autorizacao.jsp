<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                <h2 class="display-1">Ops! Acesso Negado!</h2>

                <p class="lead">Nao tem credencial para aceder essa pagina</p>

                <p class="text-muted">Por favor contacte o administrador do sistema@</p>

                <a href="/SPVPetromoc/entrar">Voltar</a>
            </div>
        </div>
    </body>
</html>
