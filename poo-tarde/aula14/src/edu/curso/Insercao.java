package edu.curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Insercao {
    final static String URL = "jdbc:mariadb://localhost:3307/agendadb?allowMultiQueries=true";
    final static String USER = "root";
    final static String PASS = "alunofatec";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome:");
        String nome = input.nextLine();
        System.out.println("Digite o email:");
        String email = input.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = input.nextLine();
        input.close();
        try { 
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            String sql = """
                INSERT INTO contatos (nome, email, telefone) 
                VALUES (?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nome);
            stm.setString(2, email);
            stm.setString(3, telefone);
            stm.executeUpdate();
            System.out.println("Inserido com sucesso");
            con.close();
        } catch( SQLException e ) { 
            e.printStackTrace();
        }
    }
}
