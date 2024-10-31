import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestePropriedades { 

    public static void notificar(String antigo, String novo) { 
        System.out
         .printf("Nome alterado de %s para %s %n",
         antigo, novo);
    }

    public static void main(String[] args) {
        StringProperty nome = 
            new SimpleStringProperty("");
        nome.addListener( (obj, valorAntigo, valorNovo) -> {
            notificar(valorAntigo, valorNovo);
        });
        nome.set("Joao");
        nome.set("Jose");
        nome.set("");
        nome.set("Maria");
    }
}