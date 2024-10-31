package edu.curso;

import javafx.application.Application;

public class Principal { 
    public static void main(String[] args) { 
        // Contato c1 = new Contato();
        // c1.setNome("Joao Silva");
        // c1.setTelefone("(11) 1111-1111");
        // c1.setEmail("joao@teste.com");
        // System.out.println(c1);

        Application.launch(ContatoBoundary.class, args);
    }
}