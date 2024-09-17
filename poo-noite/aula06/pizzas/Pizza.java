package pizzas;
public abstract class Pizza { 
    int tamanho = 3; //  1-broto  2-media   3-grande
    int numero_fatias;
    double preco;

    public Pizza(int tamanho){ 
        this.tamanho = tamanho;
        if (this.tamanho == 1) { 
            this.numero_fatias = 4;
        } else if (this.tamanho == 2) { 
            this.numero_fatias = 8;
        } else { 
            this.numero_fatias = 12;
        }
    }

    public abstract void preparar();
    public abstract void assar();
    public void cortar() { 
        System.out.printf("Cortando em %d fatias%n", 
                            this.numero_fatias);
    }
}