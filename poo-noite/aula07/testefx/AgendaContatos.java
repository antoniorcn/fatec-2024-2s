package testefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AgendaContatos extends Application {

    @Override
    public void start(Stage stage)  { 
        GridPane grid = new GridPane();
        Scene scn = new Scene(grid, 800, 300);

        TextField txtId = new TextField();
        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        Label lblId = new Label("Id: ");
        grid.add(lblId, 0, 0);
        grid.add(txtId, 1, 0);
        grid.add(new Label("Nome: "), 0, 1);
        grid.add(txtNome, 1, 1);
        grid.add(new Label("Telefone: "), 0, 2);
        grid.add(txtTelefone, 1, 2);

        Button btnGravar = new Button("Gravar");
        Button btnPesquisar = new Button("Pesquisar");

        HBox paneBotoes = new HBox();
        paneBotoes.getChildren().addAll(btnGravar, btnPesquisar);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30.0);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70.0);

        grid.getColumnConstraints().addAll(col1, col2);

        grid.add(paneBotoes, 0, 3);

        grid.setStyle("-fx-padding: 20px");

        stage.setScene(scn);
        stage.setTitle("Agenda de Contato");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AgendaContatos.class, args);
    }
    
}
