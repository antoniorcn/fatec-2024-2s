package edu.curso;

public class TesteIncremento { 

    public static void main(String[] args) { 
        int a = 10;
        a++;
        int b = a;
        int c = a++ + ++b;
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
    }
}