package edu.curso.observer;


public class FolhaPagamento implements Consumidor { 

    @Override
    public void receberAviso( Funcionario f ) {
        System.out.println("Aviso recebido");
        System.out.println("Nome: " + f.getNome());
        System.out.println("Horas Trabalhadas: " + f.getHorasTrabalhadas());
    }
}