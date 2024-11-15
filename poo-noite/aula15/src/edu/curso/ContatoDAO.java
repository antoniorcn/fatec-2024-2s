package edu.curso;

import java.util.List;

public interface ContatoDAO {

    void inserir( Contato c ) throws ContatoException;
    void atualizar( Contato c ) throws ContatoException;
    void remover( Contato c ) throws ContatoException;
    List<Contato> pesquisarPorNome( String nome ) throws ContatoException;
    
}
