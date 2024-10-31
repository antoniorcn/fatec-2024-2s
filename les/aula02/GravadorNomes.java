import java.io.FileWriter;
import java.io.IOException;

public class GravadorNomes { 
    public static void main(String[] args) { 
        System.out.println("Gravador de nomes");


        try (FileWriter fw = new FileWriter("D:/temp/les/nomes.txt")) {
            fw.write("Ola mundo - FileWriter Java");
            System.out.println("Gravado com sucesso");
        } catch(IOException e) { 
            System.err.println("Erro ao abrir o arquivo para gravação");
            e.printStackTrace();
        }
        
    }
}