package pizzas;

public class PizzaCalabresa extends Pizza {
    public PizzaCalabresa(int tamanho){ 
        super(tamanho);
    }
    @Override
    public void preparar() { 
        System.out.println("Colocando molho, calabresa e cebola");
    }
    @Override
    public void assar() { 
        System.out.println("Assando por 7 minutos");
    }  
}
