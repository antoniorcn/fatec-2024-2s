package edu.curso.empresa;

import edu.curso.animal.Animal;
import edu.curso.animal.Burro;

public class Empresa {
    public static void main(String[] args) {
        boolean comAumento = true;
        Operario o1 = new Operario("Ricardo", 220);
        Operario o2 = new Operario("Luiza", 160);
        Operario o3 = new Operario("Bob", 180);
        Pagamentos pag = new Pagamentos();
        if (comAumento) { 
            pag = new PagamentoNovo();
        }

        System.out.println("Classe de Pagamento usada: " + pag.getClass().getName());

        if (pag instanceof PagamentoNovo) { 
            System.out.println("Estou usando o Pagamento Novo");
        } else { 
            System.out.println("Estou usando o Pagamento Antigo");
        }

        pag.pagarSalario( o1 );
        pag.pagarSalario( o2 );
        pag.pagarSalario( o3 );

        Fatura<Operario> fat = new Fatura<>();
        fat.cobrar(o1);
        fat.cobrar(o2);
        fat.cobrar(o3);

        Fatura<Pagamentos> fatPag = new Fatura<>();
        fatPag.cobrar(pag);

        Burro burro = new Burro();
        Fatura<Animal> fatAnimal = new Fatura<>();
        fatAnimal.cobrar(burro);
        burro.empacar();
    }
}
