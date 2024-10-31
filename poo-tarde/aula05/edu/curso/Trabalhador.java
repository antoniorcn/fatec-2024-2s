package edu.curso;
public class Trabalhador {

    public String nome;
    private int horas;

    public Trabalhador(String nome, int horas) { 
        this.nome = nome;
        this.horas = horas;
    }

    public void receberSalario(double salario) { 
        System.out.printf("Trabalhador %s recebeu %7.2f%n", 
            this.nome, salario);
    }

    public int getHoras(){
        return this.horas;
    }
    
}
