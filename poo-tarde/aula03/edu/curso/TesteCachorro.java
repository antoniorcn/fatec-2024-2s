package edu.curso;
public class TesteCachorro { 

    public static void main(String[] args) {
        Cachorro c1 = new Cachorro();
        c1.nome = "Toto";
        c1.raca = "Generico";

        Cachorro c2 = new Cachorro();
        c2.nome = "Rex";
        c2.raca = "Pastor Alemão";

        Cachorro c3 = c1;
        
        c1.dormir();
        c2.latir();
    }
}