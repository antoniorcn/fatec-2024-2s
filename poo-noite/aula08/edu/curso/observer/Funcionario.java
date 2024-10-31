package edu.curso.observer;

import java.util.ArrayList;
import java.util.List;

public class Funcionario implements Produtor {

    private String matricula;
    private String nome;
    private double salarioBase;
    private int horasTrabalhadas;
    private List<Consumidor> consumidores = new ArrayList<>();

    public void adicionarConsumidor( Consumidor c ) { 
        consumidores.add(c);
    }

    public void removerConsumidor( Consumidor c ) { 
        consumidores.remove(c);
    }

    public void avisar() {  
        for (Consumidor c : consumidores) { 
            c.receberAviso( this );
        }
    }


    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
        avisar();
    } 
}
