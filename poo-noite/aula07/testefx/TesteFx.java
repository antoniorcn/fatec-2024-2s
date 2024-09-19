package testefx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class TesteFx extends Application { 
    @Override
    public void start(Stage stage) { 
        Pane painel = new Pane();
        painel.setStyle("-fx-background-color: yellow");

        Label hello = new Label("Hello World");
        painel.getChildren().add(hello);

        Scene scn = new Scene(painel);
        stage.setScene(scn);
        stage.setTitle("Teste do JavaFX");
        stage.show();
    }
}
