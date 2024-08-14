import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("Servidor iniciado");
        try (ServerSocket servidor = new ServerSocket( 80 )) { 
            System.out.println("Servidor ativo na porta 80");
            Socket cliente = servidor.accept();
            OutputStream out = cliente.getOutputStream();
            InputStream in = cliente.getInputStream();
            boolean sair = false;
            out.write("\nBem vindo ao servidor Java".getBytes());
            out.flush();

            Scanner scan = new Scanner(in);
            while (! sair) { 
                if(scan.hasNextLine()) {
                    String linha = scan.nextLine();
                    if ("SAIR".equals(linha)) { 
                        out.write("\nTa bom... Tchau...".getBytes());
                        out.flush();
                        sair = true;
                    }
                    System.out.println(linha);
                } 
            }
            scan.close();

            System.out.println("Cliente conectado no servidor");
            System.out.println("Comunicação encerrada");
        } catch (IOException e) { 
            System.err.println("Erro na comunicação de rede");
            e.printStackTrace();
        }
    }
}
