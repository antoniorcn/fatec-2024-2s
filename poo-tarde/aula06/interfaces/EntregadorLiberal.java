package interfaces;

public class EntregadorLiberal extends Entregador 
    implements Motorista {
    
        @Override
        public void dirigir() { 
            System.out.println("Dirigindo bem rápido...");
        }

        @Override
        public void abrirPorta() { 
            System.out.println("Abrindo a porta de dentro do carro...");
        }

}
