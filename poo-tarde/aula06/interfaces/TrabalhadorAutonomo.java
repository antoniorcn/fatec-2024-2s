package interfaces;

public class TrabalhadorAutonomo extends Trabalhador
    implements Investidor, Autodidata, Motorista {
        @Override
        public void investir() { 
            System.out.println("Investindo na poupança");
        }

        @Override
        public void dirigir() { 
            System.out.println("Dirigindo devagar para não bater");
        }

        @Override
        public void abrirPorta() { 
            System.out.println("Abrindo a porta com pressa");
        }

        @Override
        public void estudar() {
            System.out.println("Estudando enquanto espera cliente");
        }
}
