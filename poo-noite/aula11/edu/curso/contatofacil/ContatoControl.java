package edu.curso.contatofacil;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ContatoControl {
    private StringProperty nome = 
        new SimpleStringProperty("");
    private StringProperty telefone = 
        new SimpleStringProperty("");
    private IntegerProperty idade = 
        new SimpleIntegerProperty(0);

    private List<Contato> lista = new ArrayList<>();

    public StringProperty nomeProperty() { 
        return nome;
    }
    public StringProperty telefoneProperty()  {
        return telefone;
    }
    public IntegerProperty idadeProperty() { 
        return idade;
    }

    public void salvar() { 
        Contato c = paraContato();
        lista.add( c );
        limparCampos();
    }

    public void pesquisar() {
        for( Contato c : lista) { 
            if(c.getNome().contains(nome.get())) {
                paraTela( c );
                break;
            }
        }
    }

    public void paraTela( Contato c ) { 
        nome.set( c.getNome() );
        telefone.set( c.getTelefone() );
        idade.set( c.getIdade() );
    }

    public Contato paraContato() {
        Contato c = new Contato();
        c.setNome(nome.get());
        c.setTelefone(telefone.get());
        c.setIdade(idade.get());
        return c;
    }


    public void limparCampos() { 
        nome.set("");
        telefone.set("");
        idade.set(0);
    }
}
