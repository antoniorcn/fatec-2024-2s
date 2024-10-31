package pizzas;

public abstract class Pizza {
    public int tamanho = 3; // 1 - pequeno    2 - medio    3 - grande
    public String sabor;

    public final void cortar() { 
        if (tamanho == 1) { 
            System.out.println("Cortada em 2 pedaços");
        } else if (tamanho == 2) { 
            System.out.println("Cortada em 4 pedaços");
        } else { 
            System.out.println("Cortada em 8 pedaços");
        }
    }

    public abstract void preparar();

    public abstract void assar();

    // public void servir(int qtdPedacos) { 
    //     qtdPedacos = 10;
    // }
}
