package edu.curso.animal;

public class Animal { 

    String especie;

    public Animal(String especie) { 
        this.especie = especie;
    }

    void respirar() {
        System.out.printf("%s respirando...", this.especie);
    }

    void dormir() { 
        System.out.printf("%s dormindo...", this.especie);
    }
}