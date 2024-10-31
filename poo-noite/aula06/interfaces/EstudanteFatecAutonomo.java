package interfaces;

public class EstudanteFatecAutonomo extends EstudanteFatec 
    implements BomMotorista {

    @Override 
    public void dirigir() { 
        System.out.println("Dirigindo com cuidado...");
    }

    @Override
    public void abrirPorta() { 
        System.out.println("Abrindo porta com educação...");
    }
    
}
