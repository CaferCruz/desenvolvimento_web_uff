<%-- 
    Document   : bemvindo
    Created on : 13/07/2016, 20:25:22
    Author     : Romulo
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem vindo</title>
    </head>
    <body>
        <% Usuario usuario = (Usuario) session.getAttribute("usuario");%>
        <h1>Bem vindo a loja virtual de ingressos</h1>
        <a href="mvc?logica=ListaEventosLogic">Visualizar eventos</a> | 

        <% if (usuario != null) { %>
            <a href="detalhes-cliente.jsp">Meus dados</a>
        <% } else { %>
            <a href="login.jsp">Realizar Login</a>
        <% } %>
    </body>
</html>
