package edu.curso;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ContatoBoundary extends Application {
    
    private TextField txtNome = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtEmail = new TextField();
    private List<Contato> lista = new ArrayList<Contato>();

    @Override
    public void start(Stage stage) { 
        GridPane pane = new GridPane();
        ColumnConstraints colLabels = new ColumnConstraints();
        colLabels.setPercentWidth(30);
        ColumnConstraints colTextFields = new ColumnConstraints();
        colTextFields.setPercentWidth(70);
        pane.getColumnConstraints().addAll(colLabels, colTextFields);

        RowConstraints linhaConstraint = new RowConstraints();
        linhaConstraint.setPercentHeight(25.0);

        pane.getRowConstraints().addAll(linhaConstraint, linhaConstraint,
                    linhaConstraint, linhaConstraint);

        Scene scn = new Scene(pane, 600, 300);

        pane.add(new Label("Nome: "), 0, 0);
        pane.add(txtNome, 1, 0);
        pane.add(new Label("Telefone: "), 0, 1);
        pane.add(txtTelefone, 1, 1);
        pane.add(new Label("Email: "), 0, 2);
        pane.add(txtEmail, 1, 2);

        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction( e -> { lista.add(boundaryToEntity()); } );
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction( e -> {
            for (Contato c : lista) { 
                if (c.getNome().contains(txtNome.getText())) {
                    entityToBoundary(c);
                }
            }
        } );
        pane.add(btnGravar, 0, 3);
        pane.add(btnPesquisar, 1, 3);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public Contato boundaryToEntity() { 
        Contato c = new Contato();
        c.setNome( txtNome.getText() );
        c.setTelefone( txtTelefone.getText() );
        c.setEmail( txtEmail.getText() );
        return c;
    }

    public void entityToBoundary( Contato c ){ 
        txtNome.setText( c.getNome() );
        txtTelefone.setText( c.getTelefone() );
        txtEmail.setText( c.getEmail() );
    }

}
