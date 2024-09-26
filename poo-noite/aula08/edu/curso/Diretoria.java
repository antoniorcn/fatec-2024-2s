package edu.curso;

public class Diretoria implements Consumidor {
    
    public void receberAviso( Funcionario f ){
        System.out.println("Parabens da diretoria, apreciamos muito sua contribuição para nossa empresa");
        System.out.println("Parabens: " + f.getNome());
    }

}
