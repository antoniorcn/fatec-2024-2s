package edu.curso;

public class Cobrador<T> {

    public void cobrarDinheiro( T objeto ) { 
        System.out.printf(
            "Cobrando dinheiro da: %s%n",
            objeto.getClass().getName()
        );
    }
    
}
