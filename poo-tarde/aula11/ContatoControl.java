import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContatoControl {
    
    private StringProperty nome = new SimpleStringProperty();

    public StringProperty nomeProperty() { 
        return nome;
    }

    public void mostrar() { 
        System.out.println("Valor atual do nome: " + nome.get());
        nome.set("");
    }
}
