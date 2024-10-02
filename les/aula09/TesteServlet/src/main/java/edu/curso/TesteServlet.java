package edu.curso;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {
		System.out.println("TesteServlet doPost executado");
		BufferedReader bf = new BufferedReader(req.getReader());
		StringBuffer corpo = new StringBuffer();
		while (bf.ready()) {
			corpo.append(bf.readLine());
		}
		bf.close();
		
		System.out.println("Extraido o corpo: " + corpo);
		
		Gson gson = new Gson();
		
		Contato c = gson.fromJson(corpo.toString(), 
				Contato.class);
		
		System.out.println("Contato identificado: ");
		System.out.println("Nome: " + c.getNome());
		System.out.println("Telefone: " + c.getTelefone());
		System.out.println("Email: " + c.getEmail());
		res.setStatus(HttpServletResponse.SC_OK);
	}
}
