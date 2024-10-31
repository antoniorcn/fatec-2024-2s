package edu.curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns="/agendaMVC")
public class AgendaServlet extends HttpServlet {
    private List<Contato> lista = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.sendRedirect("./agenda_form.jsp");
        System.out.println("O Servlet /agendaMVC foi invocado, respondeu para acessar o ./agenda_form.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                    throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String acao = request.getParameter("acao");
        if ("gravar".equals(acao)) {
            Contato c = new Contato(nome, email, telefone);
            // System.out.printf("Nome: %s\tEmail: %s\tTelefone: %s\tAcao: %s%n", 
            // nome, email, telefone, acao);
            System.out.println("Contato: " + c.toString());
            lista.add(c);
        } else if ("pesquisar".equals(acao)) { 
            for (Contato c : lista) { 
                if (c.nome().contains( nome )) { 
                   request.getSession(true).setAttribute("CONTATO", c); 
                   break;
                }
            }
        }

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.sendRedirect("./agenda_form.jsp");
    }
}    
