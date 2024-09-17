package interfaces;

public class EstudanteFatec extends Estudante implements Autodidata, Motorista {
    @Override
    public void dirigir() { 
        System.out.println("Dirigindo loucamente...");
    }

    @Override
    public void abrirPorta() { 
        System.out.println("Abrindo a porta educadamente...");
    }

    @Override
    public void estudar() {
        System.out.println("Lendo o livro Java Code Convention");
    }   
}
