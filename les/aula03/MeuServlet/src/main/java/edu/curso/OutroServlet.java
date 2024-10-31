package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Outro")
public class OutroServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String valor = request.getParameter("nome");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Outro servlet</h1>");
		out.println("<h2>Bem vindo " + valor + "</h2>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}


}
