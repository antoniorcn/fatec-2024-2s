package testefx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class TesteFx extends Application { 
    @Override
    public void start(Stage stage) { 
        Pane painel = new Pane();
        painel.setStyle("-fx-background-color: yellow");
        Label hello = new Label("Hello World");
        painel.getChildren().add(hello);
        TextField txtNome = new TextField();
        painel.getChildren().add(txtNome);
        Button btnOk = new Button("Ok");
        painel.getChildren().add(btnOk);
        btnOk.relocate(350.0, 400.0);
        Scene scn = new Scene(painel, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste do JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TesteFx.class, args);
    }
}
