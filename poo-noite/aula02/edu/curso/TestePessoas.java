package edu.curso;
import edu.curso.Pessoa;

public class TestePessoas { 
    public static void main(String[] args) { 
        Pessoa p1 = new Pessoa();
        p1.nome = "João";
        p1.idade = 30;
        p1.imprimir();

        Pessoa p2 = new Pessoa();
        p2.nome = "Maria";
        p2.idade = 32;
        p2.imprimir();

        Pessoa p3 = p1;


    }
}