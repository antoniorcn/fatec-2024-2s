import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TesteBoundary extends Application {
    private TesteControl control = new TesteControl();
    @Override
    public void start(Stage stage) { 
        VBox painel = new VBox();

        Scene scn = new Scene(painel, 300, 200);

        painel.getChildren().add(new Label("Texto: "));
        TextField txtTexto = new TextField("");

        txtTexto.textProperty().addListener((obj, antigo, novo)-> {
            control.setTexto(novo);
        });

        control.textoProperty().addListener( (obj, antigo, novo)-> { 
            txtTexto.setText(novo);
        }); 

        painel.getChildren().add(txtTexto);
        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction( e -> { 
            control.salvar();
        });
        painel.getChildren().add(btnSalvar);

        stage.setScene(scn);
        stage.setTitle("Teste de Propriedade");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
