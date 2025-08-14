<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page import="dev.marques.jspproject.model.JavaBeans" %>
<%@page import="java.util.List" %>

<%
    List<JavaBeans> list = (List<JavaBeans>) request.getAttribute("contatos");
%>
<html lang="pt-br">
<head>
    <title>Agenda de contatos</title>
    <link rel="icon" href="img/phone.png">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Agenda de contatos</h1>
<table id="tabela">
    <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Fone</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
    <%
        for(JavaBeans j : list){%>
    <tr>
        <td><%= j.getIdcon() %></td>
        <td><%= j.getNome() %></td>
        <td><%= j.getFone() %></td>
        <td><%= j.getEmail() %></td>
    </tr>
    <%}%>
    </tbody>
</table>

<a href="novo.html" class="Botao1">Novo contato</a>
</body>
</html>
