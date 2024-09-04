<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE html>
<%@page import="edu.curso.Contato"%>  
<html lang="en">
<head>
    <title>Agenda de Contatos</title>
</head>
<body>

    <%
        Contato contato = (Contato) session.getAttribute("CONTATO");
        if (contato == null) { 
            contato = new Contato("", "", "");
        }
    %>

    <h1>Agenda de contatos</h1>
    <form action="./agendaMVC" method="POST">
        <table>
            <tbody>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="nome" value="<%=contato.nome()%>"/></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="email" name="email" value="<%=contato.email()%>"/></td>
                </tr>
                <tr>
                    <td>Telefone: </td>
                    <td><input type="text" name="telefone" value="<%=contato.telefone()%>"/></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" name="acao" value="gravar">Gravar</button>
                    </td>
                    <td>
                        <button type="submit" name="acao" value="pesquisar">Pesquisar</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
