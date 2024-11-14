package edu.curso;

import java.util.List;

public interface ContatoDAO {

    void inserir(Contato c);
    void atualizar(Contato c);
    void remover(Contato c);
    List<Contato> pesquisarPorNome(String nome);
    
}
