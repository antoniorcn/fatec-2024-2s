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

public class ContatoBoundary extends Application {
    
    private TextField txtNome = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtEmail = new TextField();
    private ContatoControl control = new ContatoControl();
 
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
        btnGravar.setOnAction( e -> { 
            control.gravar( boundaryToEntity() );
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Agenda de Contatos");
            alert.setHeaderText("Informativo");
            alert.setContentText("Contato foi salvo com sucesso");
            alert.show();
            txtNome.setText("");
            txtTelefone.setText("");
            txtEmail.setText("");
        });
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction( e -> { 
            Contato c = control.pesquisar(txtNome.getText());
            if (c != null) {
                entityToBoundary( c ); 
            } else { 
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Agenda de Contatos");
                alert.setHeaderText("Aviso");
                alert.setContentText("Não foi encontrado um contato com este nome");
                alert.show();                
            }
        });
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
        if (c != null) {
            txtNome.setText( c.getNome() );
            txtTelefone.setText( c.getTelefone() );
            txtEmail.setText( c.getEmail() );
        }
    }

}
