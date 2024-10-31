package edu.curso.animal;

public class Cavalo extends Animal {
    
    public Cavalo() { 
        super("Cavalo");
    }

    public void dormir() { 
        super.dormir();
        System.out.println(" de pe");
    }
}
