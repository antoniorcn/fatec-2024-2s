import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Idades {
    public static void main(String[] args) {
        IntegerProperty idade = 
            new SimpleIntegerProperty(0);

        idade.addListener((obj, valorAntigo, valorNovo) -> { 
            if(valorNovo.intValue() >= 18) { 
                System.out.printf("%d é Maior de idade%n", valorNovo.intValue());
            } else { 
                System.out.printf("%d ainda é de menor%n", valorNovo.intValue());
            }
        });

        idade.set(10);
        idade.set(20);
        idade.set(30);
        idade.set(40);
        idade.set(6);
        idade.set(11);
    }   
}
