package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MeuServlet")
public class MeuServlet implements Servlet {
	private ServletConfig config;


	@Override
	public void destroy() {
		System.out.println("Servlet Destruido");
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return "Este é um Servlet de Teste";
	}

	@Override
	public void init(ServletConfig sc) throws ServletException {
		this.config = sc;
		System.out.println("Servlet Iniciado");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Acionado");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Ola bem vindo ao meu servlet</h1></body></html>");
		out.flush();
		
	}
}
