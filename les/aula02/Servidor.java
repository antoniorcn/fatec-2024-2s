import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("Servidor iniciado");
        try (ServerSocket servidor = new ServerSocket( 80 )) { 
            System.out.println("Servidor ativo na porta 80");
            Socket cliente = servidor.accept();
            InetSocketAddress socketAddress = (InetSocketAddress) cliente.getRemoteSocketAddress();
            String clientIpAddress = socketAddress.getAddress().getHostAddress();
            System.out.println("Cliente conectado");
            System.out.println("Remote Socket Address: " + 
            clientIpAddress);
            System.out.println("Local Socket Name: " + 
                cliente.getLocalSocketAddress());
            OutputStream out = cliente.getOutputStream();
            InputStream in = cliente.getInputStream();
            boolean sair = false;
            out.write("\n\rBem vindo ao servidor Java".getBytes());
            out.flush();

            Scanner scan = new Scanner(in);
            Scanner scanKeyboard = new Scanner(System.in);
            while (! sair) { 
                if(in.available() > 0) {
                    String linha = scan.next();
                    if ("SAIR".equals(linha)) { 
                        out.write("\n\rTa bom... Tchau...".getBytes());
                        out.flush();
                        sair = true;
                    } else if ("CALCULADORA".equals(linha)) { 
                        Runtime.getRuntime().exec("calc.exe");
                    }
                    System.out.println(linha);
                } 
                if (System.in.available() > 0) { 
                    String linhaDigitada = scanKeyboard.next() + "\n\r";
                    out.write(linhaDigitada.getBytes());
                    out.flush();
                }
            }
            scan.close();
            scanKeyboard.close();
            System.out.println("Comunicação encerrada");
        } catch (IOException e) { 
            System.err.println("Erro na comunicação de rede");
            e.printStackTrace();
        }
    }
}
