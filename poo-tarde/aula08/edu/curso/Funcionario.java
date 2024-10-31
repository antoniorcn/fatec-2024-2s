package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class Funcionario implements Publicadora { 
    private String matricula = "";
    private String nome = "";
    private int horasTrabalhadas = 0;
    private double salarioBase = 0.0;
    private List<Assinante> assinantes = new ArrayList<>();

    public Funcionario(
        String matricula, String nome, 
        int horasTrabalhadas, double salarioBase) { 
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.horasTrabalhadas = horasTrabalhadas;    
    }

    @Override
    public void adicionarAssinante(Assinante a) { 
        assinantes.add(a);
    }

    @Override
    public void removerAssinante(Assinante a) { 
        assinantes.remove(a);
    }

    @Override
    public void publicar() { 
        for (Assinante a : assinantes) { 
            a.receberAviso(this);
        }
    }

    public String getMatricula() { 
        return this.matricula;
    }
    public void setMatricula(String valor) { 
        this.matricula = valor;
    }

    public String getNome() { 
        return this.nome;
    }
    public void setNome(String valor) { 
        this.nome = valor;
    }

    public int getHorasTrabalhadas() { 
        return this.horasTrabalhadas;
    }
    public void setHorasTrabalhadas(int valor) { 
        this.horasTrabalhadas = valor;
        this.publicar();
    }

    public double getSalarioBase() { 
        return this.salarioBase;
    }
    public void setSalarioBase(double valor) { 
        this.salarioBase = valor;
    }


}