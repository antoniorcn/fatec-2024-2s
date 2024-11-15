package edu.curso;

public class ContatoException extends Exception {

    public ContatoException(String message) { 
        super(message);
    }

    public ContatoException() { 
        super();
    }

    public ContatoException( Throwable t ) { 
        super(t);
    }
    
}
