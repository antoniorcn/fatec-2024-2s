package pizzas;

public class PizzaMussarela extends Pizza {
    public PizzaMussarela() { 
        this.sabor = "Mussarela";
    }

    @Override
    public void preparar() { 
        final int a;
        a = 10;
        System.out.printf("Preparando pizza %s%n", this.sabor);
        System.out.println("Colocar molhor e queijo mussarela");
    }

    @Override
    public void assar() { 
        System.out.printf("Assando pizza %s%n", this.sabor);
        System.out.println("Assar por 4 minutos");
        System.out.println("Adicionar oregano e azeitonas");
    }
}
