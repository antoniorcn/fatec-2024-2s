package edu.curso;

public class Aluno extends Pessoa { 
    String ra;
    Carteirinha carteirinha = new Carteirinha();

    public Aluno(String ra, String nome) { 
        super(nome);
        this.ra = ra;
        System.out.printf("Instanciando Aluno (RA: %s, Nome: %s)%n", 
            this.ra, this.nome); 
    }

    public Aluno(String nome) { 
        this("0000", nome);
    }

    public Aluno() { 
        this("Anonimo");
    }
}