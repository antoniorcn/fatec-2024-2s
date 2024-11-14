package edu.curso;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {

    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private IntegerProperty id = new SimpleIntegerProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>(LocalDate.now());

    private ContatoDAO contatoDAO = new ContatoDAOImpl();

    private int contador = 2;

    public ContatoControl() { 
        pesquisarPorNome();
    }

    public void entidadeParaTela(Contato c) { 
        this.id.set( c.getId() );
        this.nome.set(c.getNome());
        this.telefone.set(c.getTelefone());
        this.email.set(c.getEmail());
        this.nascimento.set(c.getNascimento());
    }

    public void excluir( Contato c ) { 
        System.out.println("Excluido contato com nome: " + c.getNome());
        lista.remove( c );
    }

    public void gravar() { 
        if (id.get() == 0) { 
            Contato c = new Contato();
            contador += 1;
            c.setId(contador);
            c.setNome( this.nome.get() );
            c.setTelefone( this.telefone.get() );
            c.setEmail( this.email.get() );
            c.setNascimento( this.nascimento.get() );
            lista.add( c );
            contatoDAO.inserir(c);
        } else { 
            for (Contato c : lista) { 
                if (c.getId() == this.id.get()) { 
                    c.setNome( this.nome.get() );
                    c.setTelefone( this.telefone.get() );
                    c.setEmail( this.email.get() );
                    c.setNascimento( this.nascimento.get() );
                }
            }
        }
        limparTudo();
        System.out.println("Lista tamanho: " + lista.size());
    }

    public void limparTudo() { 
        id.set(0);
        nome.set("");
        telefone.set("");
        email.set("");
        nascimento.set(LocalDate.now());
    }

    public void pesquisarPorNome() { 
        lista.clear();
        lista.addAll( contatoDAO.pesquisarPorNome( nome.get() ) );
    }


    public ObservableList<Contato> getLista() { 
        return this.lista;
    }

    public IntegerProperty idProperty() { 
        return this.id;
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
