package edu.curso;

import java.sql.SQLException;
import java.util.List;

public interface ContatoDAO {

    void inserir(Contato c) throws AgendaException;
    void atualizar(Contato c) throws AgendaException;
    void remover(Contato c) throws AgendaException;
    List<Contato> pesquisarPorNome(String nome) throws AgendaException;
    List<Contato> pesquisarTodos() throws AgendaException;
    
}
