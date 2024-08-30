package edu.curso;

public class Moto {
    Pneu p1;
    Pneu p2;

    public Moto() { 
        this( 14 );
    }

    public Moto( int aro ) { 
        super();
        this.p1 = new Pneu(aro);
        this.p2 = new Pneu(aro);
    }

    // public void criar( int aro ) { 
    //     this.p1 = new Pneu(aro);
    //     this.p2 = new Pneu(aro);
    // }
}
