package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class TestePessoa {
    public static void main(String[] args) {
        Passageiro p1 = new Passageiro("João");
        p1.andar();

        Pessoa p2 = new Pessoa("Maria");
        p2.andar();
        System.out.println();

        Pessoa p3 = new Passageiro("Alberto");
        p3.andar();

        Cobrador<Passageiro> cobradorPassageiro = new Cobrador<>();
        cobradorPassageiro.cobrarDinheiro(p1);

        Cobrador<Pessoa> cobradorPessoa = new Cobrador<>();
        cobradorPessoa.cobrarDinheiro(p2);
        cobradorPessoa.cobrarDinheiro(p3);

        Cobrador<String> cobradorString = new Cobrador<>();
        cobradorString.cobrarDinheiro("");

        List<String> listaTextos = new ArrayList<>();
        List<Passageiro> listaPassageiros = new ArrayList<>();

        listaPassageiros.add(p1);

        // Da erro
        // Passageiro p4 = new Pessoa("Camila");
        // p4.andar();
    }
}
