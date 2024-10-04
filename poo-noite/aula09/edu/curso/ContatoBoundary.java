package edu.curso;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ContatoBoundary extends Application{

    private TextField txtNome = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtEmail = new TextField();
    private ContatoControl control = new ContatoControl();


    @Override
    public void start(Stage stage) { 
        GridPane pane = new GridPane();
        ColumnConstraints col30 = new ColumnConstraints();
        col30.setPercentWidth(30.0);
        ColumnConstraints col70 = new ColumnConstraints();
        col70.setPercentWidth(70.0);
        pane.getColumnConstraints().addAll( col30, col70 );

        RowConstraints row25 = new RowConstraints();
        row25.setPercentHeight(25.0);
        pane.getRowConstraints().addAll(row25, row25, row25, row25);

        Scene scn = new Scene(pane, 600, 400);

        pane.add(new Label("Nome: "), 0, 0);
        pane.add(txtNome, 1, 0);
        pane.add(new Label("Email: "), 0, 1);
        pane.add(txtEmail, 1, 1);
        pane.add(new Label("Telefone: "), 0, 2);
        pane.add(txtTelefone, 1, 2);

        Button btnGravar = new Button("Gravar");
        Button btnPesquisar = new Button("Pesquisar");
        btnGravar.setOnAction( e -> {
            Contato c = telaParaContato();
            control.gravar( c );
            Alert alert = new Alert(AlertType.INFORMATION, 
                "Contato gravado com sucesso");
            alert.showAndWait();
            txtNome.setText("");
            txtEmail.setText("");
            txtTelefone.setText("");
        });
        btnPesquisar.setOnAction( e -> {
            Contato c = control
                            .pesquisarPorNome( txtNome.getText() );
            if (c == null) { 
                Alert alert = new Alert(AlertType.WARNING, 
                        "Não há contatos com este nome");
                alert.showAndWait();
            } else { 
                contatoParaTela( c );
            }
        });

        pane.add(btnGravar, 0, 3);
        pane.add(btnPesquisar, 1, 3);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }

    public Contato telaParaContato() { 
        Contato c = new Contato();
        c.setNome(  txtNome.getText()   );
        c.setTelefone(  txtTelefone.getText()   );
        c.setEmail(  txtEmail.getText()   );
        return c;
    }

    public void contatoParaTela( Contato c ) { 
        if (c != null) {
            txtNome.setText( c.getNome() );
            txtTelefone.setText( c.getTelefone() );
            txtEmail.setText( c.getEmail() );
        }
    }
    
}
