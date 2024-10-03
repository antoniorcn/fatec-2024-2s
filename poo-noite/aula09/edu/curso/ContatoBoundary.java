package edu.curso;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContatoBoundary extends Application{

    private TextField txtNome = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtEmail = new TextField();
    private List<Contato> lista = new ArrayList<>();

    @Override
    public void start(Stage stage) { 
        GridPane pane = new GridPane();
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
            lista.add(c);
        });
        btnPesquisar.setOnAction( e -> {
            for (Contato c : lista) { 
                if (c.getNome().contains( txtNome.getText() )) {
                    contatoParaTela( c );
                    break;
                }
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
        txtNome.setText( c.getNome() );
        txtTelefone.setText( c.getTelefone() );
        txtEmail.setText( c.getEmail() );
    }
    
}
