package edu.curso;
public class Mecanica {

    /**
     * Crie uma classe chamada Pneu
     *  contendo os seguintes atributos
     *  aro : int
     *  marca : String
     *  Faça um construtor para que ao ser 
     * criado o Pneu seja obrigatorio informar
     * o aro e a marca
     * 
     * 
     * Crie uma classe chamada Carro
     * contendo os seguintes atributos
     *  marca : String
     *  modelo : String
     *  ano : int
     *  p1, p2, p3, p4, p5 : Pneu 
     *  (devem ser instanciados no construtor 
     *      com aro 14 e marca Pirelli)
     */
    

     public static void main(String[] args) {
        Carro c1 = new Carro("Hyundai", "HB20", 2019);
        Carro c2 = new Carro("Fiat", "Moby", 2023);
        Carro c3 = new Carro("Mercedes-Benz", "Classe A", 2010);

        Pneu pextra = new Pneu(18, "Goodyear");
        // Motor motorGuardado = c1.motor;

        c1 = null;

     }
}
