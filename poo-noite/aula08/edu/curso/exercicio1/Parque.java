package edu.curso.exercicio1;

public class Parque {
    public static void main(String[] args) {
        Jornal estadao = new Jornal();
        Revista veja = new Revista();
        Estagiario joao = new Estagiario();
        Estagiario maria = new Estagiario();

        estadao.adicionarAssinante(joao);
        estadao.adicionarAssinante(maria);
        veja.adicionarAssinante(maria);

        estadao.publicar("Botafogo incedeia o Morumbis");
        veja.publicar("Dono da Armani terá que dividir o Helicoptero");

    }
}
