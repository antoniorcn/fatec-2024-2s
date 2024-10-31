import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;

public class Maioridade {

    public static void main(String[] args) {
        
        IntegerProperty idade = 
                    new SimpleIntegerProperty(0);
        idade.addListener((obj, antigo, novo) -> {
            if (novo.intValue() > 18) {
                System.out.printf("%d e Maior de Idade%n", novo.intValue());
            } else { 
                System.out.printf("%d e Menor de Idade%n", novo.intValue());
            }
        });

        idade.set(10);
        idade.set(25);
        idade.set(14);
        idade.set(11);
        idade.set(40);

    }
    
}
