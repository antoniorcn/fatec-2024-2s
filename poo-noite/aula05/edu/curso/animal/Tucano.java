package edu.curso.animal;

public class Tucano extends Animal {

    public Tucano () {
        super("Ave Tucano");
    }

    public void dormir() { 
        super.dormir();
        System.out.println(" no galho");
    }
    
}
