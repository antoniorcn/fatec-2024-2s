import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class LeitorTextos {
    public static void main(String[] args) {
        
        File f = new File("D:/temp/les/texto.txt");
        System.out.println("Arquivo existe: " + f.exists());

        try (FileReader fr = 
                new FileReader(f, 
                Charset.forName("utf-8"))) { 
            int i = 0;
            while ((i = fr.read()) != -1) {
                char c = (char)i;
                System.out.print(c);
            }           
        } catch(IOException e) { 
            System.out.println("Erro ao ler o arquivo");
            e.printStackTrace();
        }

    }
}
