package interfaces;

public class EntregadorAutonomo extends Entregador 
        implements Aprendiz, Estagiario, BomMotorista {

    public void dirigir() { 
        System.out.println("Dirigindo com pressa....");
    }

    public void abrirPorta() {
        System.out.println("Abre a porta rápido ... ");
    }

    public void trabalhar() {
        System.out.println("Trabalhando com muito afinco...");
    }

    public void estudar() { 
        System.out.println("Estudando quando tem tempo ...");
    }
    
}
