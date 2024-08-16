package edu.curso;

public class HelloWorld { 

    int a = 10;

    public void fazAlgo() { 
        int b = 20;
        System.out.println("Faz algo esta sendo executada");
    }

    public static void main(String[] args) { 

        HelloWorld h1 = new HelloWorld();
        h1.a = 50;
        h1.fazAlgo();
        System.out.println("A: " + h1.a);

        System.out.println("Hello World");
    }
}