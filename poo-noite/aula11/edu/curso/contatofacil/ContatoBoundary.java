package edu.curso.contatofacil;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ContatoBoundary extends Application {

    private TextField txtNome = new TextField("");
    private TextField txtTelefone = new TextField("");
    private TextField txtIdade = new TextField("");
    private ContatoControl control = new ContatoControl();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane painel = new GridPane();
        Scene scn = new Scene(painel, 600, 400);

        NumberStringConverter conversor = new NumberStringConverter();

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        Bindings.bindBidirectional(txtIdade.textProperty(), control.idadeProperty(), conversor);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        btnSalvar.setOnAction( e-> control.salvar() );
        btnPesquisar.setOnAction( e-> control.pesquisar() );

        painel.add(new Label("Nome: "), 0, 0);
        painel.add(txtNome, 1, 0);
        painel.add(new Label("Telefone: "), 0, 1);
        painel.add(txtTelefone, 1, 1);
        painel.add(new Label("Idade: "), 0, 2);
        painel.add(txtIdade, 1, 2);
        painel.add(btnSalvar, 0, 3);
        painel.add(btnPesquisar, 1, 3);

        stage.setScene(scn);
        stage.setTitle("Gestão de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }
    
}
