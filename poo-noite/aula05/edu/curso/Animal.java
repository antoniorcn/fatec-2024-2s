package edu.curso;

public class Animal { 

    String especie;

    public Animal(String especie) { 
        this.especie = especie;
    }

    void respirar() {
        System.out.printf("%s respirando...%n", this.especie);
    }

    void dormir() { 
        System.out.printf("%s dormindo...%n", this.especie);
    }
}