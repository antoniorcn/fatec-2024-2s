package animais;
import javafx.scene.image.Image;

public class Cachorro extends Animal {
    
    @Override
    public void fazerSom() { 
        System.out.println("Wulf wulf...");
    }
    @Override
    public String getDescricao() { 
        return """
                O melhor amigo do homem
                """;
    }
    @Override
    public Image getImage() { 
        return null;
    }
}
