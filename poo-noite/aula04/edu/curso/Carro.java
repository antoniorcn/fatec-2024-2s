package edu.curso;

public class Carro {

    private Motor motor = new Motor();

    Pneu p1;
    Pneu p2;
    Pneu p3;
    Pneu p4;
    Pneu p5;

    public Carro() { 
        p1 = new Pneu(15);
        p2 = new Pneu(15);
        p3= new Pneu(15);
        p4 = new Pneu(15);
        p5 = new Pneu(15);
        motor = new Motor();
    }
    
}
