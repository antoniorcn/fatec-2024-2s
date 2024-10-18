package edu.curso.contatos;
import javafx.beans.property.StringProperty;
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

    public StringProperty nomeProperty() { 
        return nome;
    }
    public StringProperty telefoneProperty()  {
        return telefone;
    }
    public IntegerProperty idadeProperty() { 
        return idade;
    }

    public void mostrar() { 
        System.out.println(nome.get());
        System.out.println(telefone.get());
        System.out.println(idade.get());
    }

    public void limparCampos() { 
        nome.set("");
        telefone.set("");
        idade.set(0);
    }
}
