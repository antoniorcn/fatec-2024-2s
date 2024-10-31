package pizzas;

public class Pizzaria {

    public static void main(String args[]) { 
        Pizza p1 = new PizzaMussarela(1);
        p1.preparar();
        p1.assar();
        p1.cortar();
        System.out.println("===========================");
        Pizza p2 = new PizzaCalabresa(3);
        p2.preparar();
        p2.assar();
        p2.cortar();
    }
    
}
