package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class ContatoControl {
        private List<Contato> lista = new ArrayList<Contato>();

        public void gravar( Contato c ) { 
            lista.add( c );
        }

        public Contato pesquisar( String nomeParcial ) { 
            for (Contato c : lista) { 
                if (c.getNome().contains(nomeParcial)) {
                    return c;
                }
            }
            return null;
        }

}
