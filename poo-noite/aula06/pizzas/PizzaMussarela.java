package pizzas;

public class PizzaMussarela extends Pizza {
    public PizzaMussarela(int tamanho){ 
        super(tamanho);
    }
    @Override
    public void preparar() { 
        System.out.println("Colocar molho e queijo");
    }
    @Override
    public void assar() {
        System.out.println("Assando por 5 minutos");
    }
}
