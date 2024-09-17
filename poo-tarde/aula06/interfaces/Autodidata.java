package interfaces;

public interface Autodidata { 
    void estudar();
    default void descansar() { 
        System.out.println("Descansando após os estudos...");
    }
}