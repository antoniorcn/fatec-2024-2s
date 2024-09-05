package edu.curso.empresa;

public class Empresa {
    public static void main(String[] args) {
        Operario o1 = new Operario("Ricardo", 220);
        Operario o2 = new Operario("Luiza", 160);
        Operario o3 = new Operario("Bob", 180);

        PagamentoNovo pag = new PagamentoNovo();

        pag.pagarSalario( o1 );
        pag.pagarSalario( o2 );
        pag.pagarSalario( o3 );
    }
}
