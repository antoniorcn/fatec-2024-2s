package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAOImpl implements EnderecoDAO {

    private final static String DB_CLASS = "org.mariadb.jdbc.Driver";
    private final static String DB_URL = "jdbc:mariadb://localhost:3307/agendadb?allowPublicKeyRetrieval=true";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "alunofatec";

    private Connection con = null;

    public EnderecoDAOImpl() throws AgendaException { 
        try { 
            Class.forName(DB_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) { 
            throw new AgendaException( e );
        }
    }

    @Override
    public void inserir(Endereco c) throws AgendaException {
        try { 
            String sql = """
                    INSERT INTO enderecos (logradouro, numero,
                    complemento, bairro, cidade, estado, cep)
                    VALUES (?, ?, ?, ?, ?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, c.getLogradouro() );
            stm.setInt(2, c.getNumero());
            stm.setString(3, c.getComplemento());
            stm.setString(4, c.getBairro());
            stm.setString(5, c.getCidade());
            stm.setString(6, c.getEstado());
            stm.setString(7, c.getCep());
            stm.executeUpdate();
        } catch (SQLException err) {
            throw new AgendaException(err);
        }
    }

    @Override
    public void atualizar(Endereco c) throws AgendaException {
        try { 
            String sql = """
                    UPDATE enderecos SET logradouro=?, numero=?,
                    complemento=?, bairro=?, cidade=?, estado=?, cep=?
                    WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, c.getLogradouro() );
            stm.setInt(2, c.getNumero());
            stm.setString(3, c.getComplemento());
            stm.setString(4, c.getBairro());
            stm.setString(5, c.getCidade());
            stm.setString(6, c.getEstado());
            stm.setString(7, c.getCep());
            stm.setLong(8, c.getId());
            stm.executeUpdate();
        } catch (SQLException err) {
            throw new AgendaException(err);
        }
    }

    @Override
    public void remover(Endereco c) throws AgendaException {
        try { 
            String sql = """
                    DELETE FROM enderecos
                    WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, c.getId());
            stm.executeUpdate();
        } catch (SQLException err) {
            throw new AgendaException(err);
        }
    }

    @Override
    public List<Endereco> pesquisarPorLogradouro(String logradouro) throws AgendaException {
        List<Endereco> lista = new ArrayList<>();
        try { 
            String sql = """
                    SELECT FROM enderecos
                    WHERE logradouro LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + logradouro + "%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()) { 
                Endereco endereco = new Endereco();
                endereco.setId( rs.getLong("id")  );
                endereco.setLogradouro( rs.getString("logradouro") );
                endereco.setNumero( rs.getInt("numero") );
                endereco.setComplemento( rs.getString("complemento" ) );
                endereco.setBairro( rs.getString("bairro" ) );
                endereco.setCidade( rs.getString("cidade" ) );
                endereco.setEstado( rs.getString("estado" ) );
                endereco.setCep( rs.getString("cep" ) );
                lista.add(endereco);
            }
        } catch (SQLException err) {
            throw new AgendaException(err);
        }
        return lista;
    }
}
