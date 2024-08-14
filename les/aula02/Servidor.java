import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("Servidor iniciado");
        try (ServerSocket servidor = new ServerSocket( 80 )) { 
            System.out.println("Servidor ativo na porta 80");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado no servidor");
            System.out.println("Comunicação encerrada");
        } catch (IOException e) { 
            System.err.println("Erro na comunicação de rede");
            e.printStackTrace();
        }
    }
}
