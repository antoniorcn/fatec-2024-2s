package edu.curso;

public class Aluno extends Pessoa {

    String ra;

    Aula aula1;
    Aula aula2;
    Aula aula3;

    public Aluno() { 
        super("Anonimo");
    }

    public void estudar() { 
        System.out.println("Estudando ...");
    }
}
