package edu.curso;

import java.util.List;

public interface EnderecoDAO {
    void inserir(Endereco e) throws AgendaException;
    void atualizar(Endereco e) throws AgendaException;
    void excluir(Endereco e) throws AgendaException;
    List<Endereco> pesquisarTodos() throws AgendaException;
    List<Endereco> pesquisarPorLogradouro( String logradouro ) throws AgendaException;
}
