package edu.curso;

public class TesteEscola {
    
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aula aulaPOO = new Aula();
        a1.aula1 = aulaPOO;

        Aula bd = new Aula();
        a1.aula2 = bd;

        a1.aula1 = null;
    }
}
