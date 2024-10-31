package edu.curso;
public class Contador { 
    public static void main(String args[]) { 
        int c = 1;
        while (true) { 
            c = c + 1; // c += 1;
            // if (c >= 100) { 
            //     c = 0;
            // }
            // c = c >= 100 ? 0 : c;
            // c = c % 100;
            c %= 100;
            System.out.println(c);
        }
    }
}