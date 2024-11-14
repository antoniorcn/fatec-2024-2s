package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ContatoDAOImpl implements ContatoDAO {
    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/agendadb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "alunofatec";
    private Connection con = null;
    public ContatoDAOImpl() { 
        try { 
            Class.forName(DB_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Contato c) {
        try { 
            String SQL = """
                    INSERT INTO contatos (id, nome, email, telefone, nascimento) 
                    VALUES (?, ?, ?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement( SQL );
            stm.setLong(1, 0);
            stm.setString(2, c.getNome());
            stm.setString(3, c.getEmail());
            stm.setString(4, c.getTelefone());
            java.sql.Date dt = java.sql.Date.valueOf( c.getNascimento() );
            stm.setDate(5, dt );
            int i = stm.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Contato c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void remover(Contato c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<Contato> pesquisarPorNome(String nome) {
        List<Contato> lista = new ArrayList<>();
        try { 
            String SQL = """
                    SELECT * FROM contatos WHERE nome LIKE ?       
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) { 
                Contato c = new Contato();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setNascimento(rs.getDate("nascimento").toLocalDate());
                lista.add(c);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }
    
}
