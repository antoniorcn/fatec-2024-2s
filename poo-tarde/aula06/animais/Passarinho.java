package animais;
import javafx.scene.image.Image;

public abstract class Passarinho extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("piu piu");
    }

    @Override
    public String getDescricao() {
        return "piu piu";
    }

    @Override
    public Image getImage() {
        return null;
    }
    
}
