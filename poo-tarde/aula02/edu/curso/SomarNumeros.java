package edu.curso;
import java.util.Scanner;
public class SomarNumeros { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        System.out.println("Por favor digite um número: ");
        double num1 = input.nextDouble();
        System.out.println("Por favor digite outro número: ");
        double num2 = input.nextDouble();
        double resultado = num1 + num2;
        System.out.printf("Resultado: %6.2f%n", resultado);
        input.close();
    }
}