package edu.curso;

public class Empresa {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        f1.setNome("Joao Silva");

        Funcionario f2 = new Funcionario();
        f2.setNome("Maria Silva");

        FolhaPagamento fp = new FolhaPagamento();
        Diretoria dir = new Diretoria();

        f1.adicionarConsumidor(fp);
        f2.adicionarConsumidor(fp);
        f2.adicionarConsumidor(dir);

        f1.setHorasTrabalhadas( 100 );
        f2.setHorasTrabalhadas( 90 );
    }
}
