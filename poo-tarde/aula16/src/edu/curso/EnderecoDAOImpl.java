package edu.curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAOImpl implements EnderecoDAO {
    @Override
    public void inserir(Endereco e) throws AgendaException {
        try { 
            String SQL = """
                    INSERT INTO enderecos (
                        logradouro, numero, complemento, bairro,
                        cidade, estado, cep ) VALUES 
                        (?, ?, ?, ?, ?, ?, ?)
                    """;
            Connection con = Conexao.getInstance().getConnection();
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, e.getLogradouro());
            stm.setLong(2, e.getNumero());
            stm.setString(3, e.getComplemento());
            stm.setString(4, e.getBairro());
            stm.setString(5, e.getCidade());
            stm.setString(6, e.getEstado());
            stm.setString(7, e.getCep());
            stm.executeUpdate();
            con.close();
        } catch (SQLException err) { 
            throw new AgendaException(err);
        }
    }

    @Override
    public void atualizar(Endereco e) throws AgendaException {
        try { 
            String SQL = """
                    UPDATE enderecos SET logradouro = ?, numero = ?, 
                        complemento = ?, bairro = ?,
                        cidade = ? , estado = ?, cep = ?
                    WHERE id = ?
                    """;
            Connection con = Conexao.getInstance().getConnection();
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, e.getLogradouro());
            stm.setLong(2, e.getNumero());
            stm.setString(3, e.getComplemento());
            stm.setString(4, e.getBairro());
            stm.setString(5, e.getCidade());
            stm.setString(6, e.getEstado());
            stm.setString(7, e.getCep());
            stm.setLong(8, e.getId());
            stm.executeUpdate();
            con.close();
        } catch (SQLException err) { 
            throw new AgendaException(err);
        }
    }

    @Override
    public void excluir(Endereco e) throws AgendaException {
        try { 
            String SQL = """
                    DELETE FROM enderecos 
                    WHERE id = ?
                    """;
            Connection con = Conexao.getInstance().getConnection();
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setLong(1, e.getId());
            stm.executeUpdate();
            con.close();
        } catch (SQLException err) { 
            throw new AgendaException(err);
        }    }

    @Override
    public List<Endereco> pesquisarTodos() throws AgendaException {
        List<Endereco> lista = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM enderecos
                    """;
            Connection con = Conexao.getInstance().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) { 
                Endereco endereco = new Endereco();
                endereco.setId( rs.getLong("id") );
                endereco.setLogradouro( rs.getString("logradouro") );
                endereco.setNumero( rs.getInt("numero") );
                endereco.setComplemento( rs.getString("complemento") );
                endereco.setBairro( rs.getString("bairro") );
                endereco.setCidade( rs.getString("cidade") );
                endereco.setEstado( rs.getString("estado") );
                endereco.setCep( rs.getString("cep") );
                lista.add( endereco );
            }
        } catch (SQLException err) { 
            throw new AgendaException(err);
        }
        return lista;
    }

    @Override
    public List<Endereco> pesquisarPorLogradouro(String logradouro) throws AgendaException {
        List<Endereco> lista = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM enderecos WHERE logradouro LIKE ?
                    """;
            Connection con = Conexao.getInstance().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + logradouro + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) { 
                Endereco endereco = new Endereco();
                endereco.setId( rs.getLong("id") );
                endereco.setLogradouro( rs.getString("logradouro") );
                endereco.setNumero( rs.getInt("numero") );
                endereco.setComplemento( rs.getString("complemento") );
                endereco.setBairro( rs.getString("bairro") );
                endereco.setCidade( rs.getString("cidade") );
                endereco.setEstado( rs.getString("estado") );
                endereco.setCep( rs.getString("cep") );
                lista.add( endereco );
            }
        } catch (SQLException err) { 
            throw new AgendaException(err);
        }
        return lista;
    }
    
}
