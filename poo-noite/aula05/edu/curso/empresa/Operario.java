package edu.curso.empresa;

public class Operario {

    public int horas;
    public String nome;

    public Operario(String nome, int horas) { 
        this.nome = nome;
        this.horas = horas;
    }

    public void recebeSalario(double salario) { 
        System.out.printf("%s recebeu %7.2f de pagamento%n", 
        this.nome, salario);
    }
    
}
