package edu.curso;

public interface Produtor {
    void adicionarConsumidor(Consumidor c);
    void removerConsumidor(Consumidor c);
    void avisar();
}
