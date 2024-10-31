package edu.curso.contatos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContatoBoundary extends Application {

    private TextField txtNome = new TextField("");
    private TextField txtTelefone = new TextField("");
    private TextField txtIdade = new TextField("");
    private ContatoControl control = new ContatoControl();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane painel = new GridPane();
        Scene scn = new Scene(painel, 600, 400);

        txtNome.textProperty().addListener((obj, antigo, novo)->{
            control.nomeProperty().set( novo );
        });
        control.nomeProperty().addListener((obj, antigo, novo)-> {
            txtNome.setText(novo);
        });

        txtTelefone.textProperty().addListener((obj, antigo, novo)->{
            control.telefoneProperty().set( novo );
        });
        control.telefoneProperty().addListener((obj, antigo, novo)-> {
            txtTelefone.setText(novo);
        });

        txtIdade.textProperty().addListener((obj, antigo, novo)->{
            control.idadeProperty().set( Integer.parseInt(novo) );
        });
        control.idadeProperty().addListener((obj, antigo, novo)-> {
            txtIdade.setText(String.valueOf(novo));
        });

        Button btnMostrar = new Button("Mostrar");
        Button btnLimpar = new Button("Limpar Campos");

        btnMostrar.setOnAction( e-> control.mostrar() );
        btnLimpar.setOnAction( e-> control.limparCampos() );

        painel.add(new Label("Nome: "), 0, 0);
        painel.add(txtNome, 1, 0);
        painel.add(new Label("Telefone: "), 0, 1);
        painel.add(txtTelefone, 1, 1);
        painel.add(new Label("Idade: "), 0, 2);
        painel.add(txtIdade, 1, 2);
        painel.add(btnMostrar, 0, 3);
        painel.add(btnLimpar, 1, 3);

        stage.setScene(scn);
        stage.setTitle("Gestão de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }
    
}
