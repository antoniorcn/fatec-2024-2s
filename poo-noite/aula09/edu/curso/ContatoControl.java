package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class ContatoControl {
    private List<Contato> lista = new ArrayList<>();

    public void gravar( Contato c ) { 
        lista.add(c);
    }

    public Contato pesquisarPorNome(String parteNome) {
        for (Contato c : lista) { 
            if (c.getNome().contains( parteNome )) { 
                return c;
            }
        }
        return null;
    }

    
}
