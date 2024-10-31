package edu.curso;

import PagamentoMelhor;

public class Empresa {

    public static void main(String[] args) {
        Trabalhador t1 = new Trabalhador("Joao", 110);
        Trabalhador t2 = new Trabalhador("Maria", 120);
        Trabalhador t3 = new Trabalhador("Alberto", 105);

        Pagamentos rh = new PagamentoMelhor();
        rh.fazPagamento(t1);
        rh.fazPagamento(t2);
        rh.fazPagamento(t3);
    }
    
}
