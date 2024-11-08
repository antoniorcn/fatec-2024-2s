package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            // String sql = """
            //     INSERT INTO contatos (nome, email, telefone)
            //     VALUES ('Maria Silva', 'maria@teste.com', '(11)2222-2222')
            // """;
            // PreparedStatement stm = con.prepareStatement(sql);
            // stm.executeUpdate();
            String sql = "SELECT * FROM contatos";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                String nome = rs.getString("nome");
                System.out.println("Nome: " + nome);
            }
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