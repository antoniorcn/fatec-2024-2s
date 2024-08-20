package edu.curso;
import java.util.Scanner;
public class Somar { 

    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um número: ");
        double num1 = input.nextDouble();
        System.out.println("Digite outro número: ");
        double num2 = input.nextDouble();
        double resultado = num1 + num2;
        System.out.printf("Resultado: %6.2f%n", resultado);
        input.close();
    }
}