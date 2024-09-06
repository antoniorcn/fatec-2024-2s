package edu.curso.empresa;

// import edu.curso.animal.Animal;

public class Fatura<T> {

    public void cobrar(T objeto) { 
        System.out.printf("Cobrando do %s%n",
            objeto.getClass().getSimpleName()
        );
    }

    // public void cobrar(Animal a) { 
    //     System.out.println("Cobrando do Animal");
    // }
    
}
