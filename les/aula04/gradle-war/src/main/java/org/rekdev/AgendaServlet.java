package org.rekdev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
@WebServlet("/AgendaAPI")
public class AgendaServlet extends HttpServlet {
    private List<String> lista = new ArrayList<>();
    public void doPost(HttpServletRequest request,
    HttpServletResponse response) { 
        try {
            BufferedReader inr = request.getReader();
            StringBuffer sb = new StringBuffer();
            while (inr.ready()) {
                sb.append(inr.readLine());
            }
            lista.add(sb.toString());
            response.setStatus(200);
            response.getWriter().println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) { 
        try { 
            PrintWriter out = response.getWriter();
            for (String linha : lista) { 
                out.println(linha);
            }
            response.setStatus(200);
        } catch(IOException e) { 
            e.printStackTrace();
        }
    }
}
