package org.rekdev;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns="/meuservlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\"/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Você escreveu seu primeiro Servlet</h1>");
        out.println("</body>");
        out.println("</html>");

        System.out.println("O Servlet /meuservlet foi invocado");

    }
}    
