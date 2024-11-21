package edu.curso;

public class AgendaException extends Exception {

    public AgendaException(String message) { 
        super(message);
    }

    public AgendaException() { 
        super();
    }

    public AgendaException( Throwable t ) { 
        super(t);
    }
    
}
