package edu.curso;

public class FolhaPagamento implements Assinante { 

    private double reservaSalarios = 0.0;


    @Override
    public void receberAviso(Funcionario f) { 
        System.out.printf(
            "Funcionario %s trocou as horas trabalhadas para %d%n", 
        f.getNome(), f.getHorasTrabalhadas());
    }

    public double getReservaSalarios() { 
        return this.reservaSalarios;
    }
    public void setReservaSalarios(double valor) { 
        this.reservaSalarios = valor;
    }
}