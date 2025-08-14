<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agenda de contatos</title>
    <link rel="icon" href="img/phone.png">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>
    Deseja excluir?
</h1>
<h2>Id: <%out.print(request.getAttribute("idcon"));%>,<br>
    Nome: <%out.print(request.getAttribute("nome"));%><br>
    Fone: <%out.print(request.getAttribute("fone"));%><br>
    Email: <%out.print(request.getAttribute("email"));%><br>
</h2>
<form name="frmDelete" action="delete">

    <input type="hidden" name="idcon" value="<%= request.getAttribute("idcon") %>">

    <input type="submit" value="Sim" class="Botao2">

    <input type="button" value="Não" class="Botao1" onclick="window.location.href='main'">
</form>

</body>
</html>