package pizzas;

public class PizzaCalabresa extends Pizza {

    public PizzaCalabresa() { 
        this.sabor = "Calabresa";
    }

    public void preparar() { 
        System.out.printf("Preparando pizza %s%n", this.sabor);
        System.out.println("Molho, linguiça calabresa fatiada e cebola");
    }

    public void assar() { 
        System.out.printf("Assando pizza %s%n", this.sabor);
        System.out.println("Deixando assar por 6 minutos");
    }
    
}
