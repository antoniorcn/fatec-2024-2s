package edu.curso;

public class Cachorro { 
    String nome;
    String raca;
    int idade;
    float peso;

    public void latir() { 
        System.out.printf(
            "Cachorro %s esta latindo...%n", nome);
    }

    public void morder() { 
        System.out.printf("Cachorro %s esta mordendo...%n", nome);
    }

    public void dormir() { 
        System.out.printf("Cachorro %s esta dormindo (Zzzzz...).%n", 
             this.nome);
    }
}