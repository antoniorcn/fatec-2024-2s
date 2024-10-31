package edu.curso;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {

    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private StringProperty nome = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty telefone = new SimpleStringProperty();
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>();

    private int contador = 0;

    public ContatoControl() { 
        Contato c1 = new Contato();
        c1.setNome("João Silva");
        c1.setEmail("joao@teste.com");
        c1.setTelefone("(11) 1111-1111");

        Contato c2 = new Contato();
        c2.setNome("Maria Silva");
        c2.setEmail("Maria@teste.com");
        c2.setTelefone("(11) 2222-2222");

        lista.addAll( c1, c2 );
    }

    public void entidadeParaTela(Contato c) { 
        this.nome.set(c.getNome());
        this.telefone.set(c.getTelefone());
        this.email.set(c.getEmail());
        this.nascimento.set(c.getNascimento());
    }

    public void gravar() { 
        Contato c = new Contato();
        contador += 1;
        c.setId(contador);
        c.setNome( this.nome.get() );
        c.setTelefone( this.telefone.get() );
        c.setEmail( this.email.get() );
        c.setNascimento( this.nascimento.get() );
        lista.add( c );
        System.out.println("Lista tamanho: " + lista.size());
    }

    public void pesquisarPorNome() { 
        for (Contato c : lista) { 
            if (c.getNome().contains( nome.get() )) { 
                nome.set( c.getNome() );
                email.set( c.getEmail() );
                telefone.set( c.getTelefone() );
                nascimento.set( c.getNascimento() );
            }
        } 

    }


    public ObservableList<Contato> getLista() { 
        return this.lista;
    }

    public StringProperty nomeProperty() { 
        return this.nome;
    }
    public StringProperty emailProperty() { 
        return this.email;
    }
    public StringProperty telefoneProperty() { 
        return this.telefone;
    }
    public ObjectProperty<LocalDate> nascimentoProperty() { 
        return this.nascimento;
    }
}
