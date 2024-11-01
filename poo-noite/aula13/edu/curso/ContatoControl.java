package edu.curso;

import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContatoControl {

    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private long contador = 2;

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = 
            new SimpleObjectProperty<>(LocalDate.now());


    public ContatoControl() { 
        lista.add( new Contato(1l, "João Silva", 
        "(11) 1111-1111", "joao@teste.com", 
        LocalDate.of(1999, 3, 10)) );

        lista.add( new Contato(2l, "Maria Silva", 
        "(11) 2222-2222", "maria@teste.com", 
        LocalDate.of(2001, 9, 20)) );
    }

    public Contato paraEntidade() { 
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setEmail( email.get() );
        c.setTelefone( telefone.get() );
        c.setNascimento( nascimento.get() );
        return c;
    }

    public void excluir( Contato c ) throws Exception { 
        if (c != null && lista.contains(c) ) { 
            if (c.getId() == 1) { 
                throw new Exception("Erro ao apagar");
            } else if (c.getId() == 2) { 
                throw new ContatoException("Erro ao apagar o usuario");
            }
            lista.remove( c );
        }
    }

    public void limparTudo() { 
        id.set( 0 );
        nome.set( "" );
        email.set( "");
        telefone.set("");
        nascimento.set(LocalDate.now());
    }

    public void paraTela(Contato c) { 
        if (c != null) {
            id.set( c.getId() );
            nome.set( c.getNome() );
            email.set( c.getEmail() );
            telefone.set( c.getTelefone() );
            nascimento.set( c.getNascimento() );
        }
    }


    public void gravar() { 
        if (this.id.get() == 0 ) { 
            this.contador += 1;
            Contato c = paraEntidade();
            c.setId( this.contador );
            lista.add( c );
        } else { 
            for (Contato c : lista) { 
                if (c.getId() == id.get()) { 
                    c.setNome( nome.get() );
                    c.setTelefone( telefone.get() );
                    c.setEmail( email.get() );
                    c.setNascimento( nascimento.get() );
                }
            }
        }
    }

    public void pesquisar() { 

        for (Contato c : lista) { 
            if (c.getNome().contains( nome.get() )) { 
                paraTela( c );
            }
        }
    }

    public LongProperty idProperty() { 
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

    public ObservableList<Contato> getLista() { 
        return this.lista;
    }
}
