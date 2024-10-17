import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TesteControl {

    private StringProperty texto = 
        new SimpleStringProperty("");

    public String getTexto() { 
        return this.texto.get();
    }
    public void setTexto(String valor) { 
        this.texto.set(valor);
    }
    public StringProperty textoProperty() { 
        return this.texto;
    }

    public void salvar() { 
        System.out.println("O texto digitado foi: " + texto.get());
        texto.set("");
    }
    
}
