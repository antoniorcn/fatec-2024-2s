import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Teste extends Application { 

    public void start(Stage stage) { 
        GridPane panel = new GridPane();
        Scene scn = new Scene(panel, 800, 600);
        stage.setScene(scn);
        Label lblTeste = new Label("Nome");
        Button btnOk = new Button("Ok");
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30.0);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70.0);
        panel.getColumnConstraints().addAll(col1, col2);
        TextField txtNome = new TextField();
        // btnOk.relocate(200.0, 400.0);
        // txtNome.setPrefSize(400.0, 30.0);
        // panel.getChildren().add(lblTeste);
        // panel.getChildren().add(btnOk);
        // panel.getChildren().add(txtNome);
        // panel.getChildren().addAll(lblTeste, txtNome, btnOk);
        panel.add(lblTeste, 0, 0);
        panel.add(txtNome, 1, 0);
        panel.add(btnOk, 0, 1);
        stage.setTitle("Teste de Aplicação Java FX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Teste.class, args);
    }
}