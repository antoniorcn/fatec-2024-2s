package interfaces;

public interface BomMotorista 
        extends Cavalheiro {
    
    void dirigir();

    default void cobrar() { 
        System.out.println("Cobrando o passageiro...");
    }
}
