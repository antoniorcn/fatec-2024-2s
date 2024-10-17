package edu.curso.alunos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class AlunoControl {

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty ra = new SimpleStringProperty("");
    private IntegerProperty idade = new SimpleIntegerProperty(0);

    private List<Aluno> lista = new ArrayList<>();

    public StringProperty nomeProperty() { 
        return nome;
    }

    public StringProperty raProperty() { 
        return ra;
    }

    public IntegerProperty idadeProperty() { 
        return idade;
    }

    public Aluno paraEntidade() {
        Aluno a = new Aluno();
        a.setNome( nome.get() );
        a.setRa( ra.get() );
        a.setIdade( idade.get() );
        return a;
    }

    public void limparCampos() { 
        ra.set("");
        nome.set("");
        idade.set(0);
    }
    
    public void paraTela( Aluno a ) { 
        nome.set( a.getNome() );
        ra.set( a.getRa() );
        idade.set( a.getIdade() );
    }

    public void salvar() { 
        Aluno a = paraEntidade();
        lista.add(a);
        limparCampos();
    }

    public void pesquisar() { 
        for (Aluno a : lista) { 
            if (a.getNome().contains( nome.get() )) { 
                paraTela(a);
                break;
            }
        }
    }
}
