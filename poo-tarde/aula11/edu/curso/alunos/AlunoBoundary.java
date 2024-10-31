package edu.curso.alunos;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class AlunoBoundary extends Application {

    private TextField txtRa = new TextField("");
    private TextField txtNome = new TextField("");
    private TextField txtIdade = new TextField("");
    private AlunoControl control = new AlunoControl();
    private Button btnSalvar = new Button("Salvar");
    private Button btnPesquisar = new Button("Pesquisar");

    @Override
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        GridPane panFormulario = new GridPane();

        panFormulario.add(new Label("Ra: "), 0, 0);
        panFormulario.add(txtRa, 1, 0);
        panFormulario.add(new Label("Nome: "), 0, 1);
        panFormulario.add(txtNome, 1, 1);
        panFormulario.add(new Label("Idade: "), 0, 2);
        panFormulario.add(txtIdade, 1, 2);
        panFormulario.add(btnSalvar, 0, 3);
        panFormulario.add(btnPesquisar, 1, 3);

        NumberStringConverter conversor = new NumberStringConverter();

        Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtIdade.textProperty(), control.idadeProperty(), conversor);

        btnSalvar.setOnAction( e -> { 
            control.salvar();
        });

        btnPesquisar.setOnAction( e -> { 
            control.pesquisar();
        });

        Scene scn = new Scene(panPrincipal, 600, 400);
        panPrincipal.setTop(panFormulario);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class, args);
    }
    
}
