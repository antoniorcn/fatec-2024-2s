package edu.curso.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Publicadora {
    private List<Assinante> assinantes = new ArrayList<>();
    public void adicionarAssinante(Assinante a) { 
        assinantes.add(a);
    }
    public void removerAssinante(Assinante a) { 
        assinantes.remove(a);
    }
    public void publicar(String noticia) { 
        for (Assinante a : assinantes) { 
            a.receberNoticia( "Extra Extra: " + noticia );
        }
    }
}
