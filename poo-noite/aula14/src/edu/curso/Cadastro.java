package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;

public class Cadastro { 
    final static String URL = "jdbc:mariadb://localhost:3307/agendadb?allowMultiqueries=true";
    final static String USER = "root";
    final static String PASS = "alunofatec";
    public static void main(String[] args) {
        System.out.println("Cadastro de Contatos no Database");
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();
        System.out.println("Digite seu email: ");
        String email = input.nextLine();
        System.out.println("Digite seu telefone: ");
        String telefone = input.nextLine();
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado com sucesso");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexao estabelecida com sucesso");
            String sql = String.format("""
                INSERT INTO contatos (nome, email, telefone)
                VALUES ('%s', '%s', '%s')
            """, nome, email, telefone);
            PreparedStatement stm = con.prepareStatement(sql);
            stm.executeUpdate();
            
            con.close();
        } catch (ClassNotFoundException e) { 
            System.out.println("Erro ao carregar a classe");
            e.printStackTrace();
        } catch (SQLException e) { 
            System.out.println("Erro de SQL");
            e.printStackTrace();
        }

    }
}