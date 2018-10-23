<%@page import="com.daw.spvpetromoc.dao.UsuarioDAO"%>
<%@page import="com.daw.spvpetromoc.model.Usuario"%>
<%
    
    Usuario usu = null;
        if (session.getAttribute("usu") != null) {
            usu = (Usuario) session.getAttribute("usu");
            
        } else {
            response.sendRedirect("login");
        }
%>
