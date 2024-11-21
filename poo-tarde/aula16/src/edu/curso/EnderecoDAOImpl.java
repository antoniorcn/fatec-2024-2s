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
            stm.executeUpdate();
            con.close();
        } catch (SQLException err) { 
            throw new AgendaException(err);
        }
    }

    @Override
    public void atualizar(Endereco e) throws AgendaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void remover(Endereco e) throws AgendaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<Endereco> pesquisarTodos() throws AgendaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarTodos'");
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
