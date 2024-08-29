package edu.curso;

import java.time.LocalDate;

public class Pessoa extends Animal {

    String cpf = "";
    String nome = "";
    LocalDate nascimento = LocalDate.now();

    public Pessoa(String nome) { 
        super();
        this.nome = nome;
        System.out.printf("Instanciando Pessoa (Nome: %s)%n", this.nome); 
    }
    
}
