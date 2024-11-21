package edu.curso;

import java.util.List;

public interface EnderecoDAO {
    
    void inserir( Endereco c ) throws AgendaException;
    void atualizar( Endereco c ) throws AgendaException;
    void remover( Endereco c ) throws AgendaException;
    List<Endereco> pesquisarPorLogradouro( String logradouro ) throws AgendaException;
    
}
