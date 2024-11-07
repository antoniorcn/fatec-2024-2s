package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDB { 
    final static String URL = "jdbc:mariadb://localhost:3307/agendadb";
    final static String USER = "root";
    final static String PASS = "alunofatec";
    public static void main(String[] args) {
        System.out.println("Teste de conexão no Database");

        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado com sucesso");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexao estabelecida com sucesso");
        } catch (ClassNotFoundException e) { 
            System.out.println("Erro ao carregar a classe");
            e.printStackTrace();
        } catch (SQLException e) { 
            System.out.println("Erro de SQL");
            e.printStackTrace();
        }

    }
}