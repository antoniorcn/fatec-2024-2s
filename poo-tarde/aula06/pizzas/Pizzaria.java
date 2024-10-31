package pizzas;

public class Pizzaria {
    public static void main(String[] args) {
        Pizza p1 = new PizzaMussarela();
        Pizza p2 = new PizzaCalabresa();

        p1.preparar();
        p1.assar();
        p1.cortar();

        p2.preparar();
        p2.assar();
        p2.cortar();
    }
    
}
