package edu.curso;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContatoBoundary extends Application {

    private Label lblId = new Label("");
    private TextField txtNome = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtTelefone = new TextField();
    private DatePicker dateNascimento = new DatePicker();

    private ContatoControl control = new ContatoControl();

    private TableView<Contato> tableView = new TableView<>();

    @Override
    public void start(Stage stage) {
        BorderPane panePrincipal = new BorderPane();
        GridPane paneForm = new GridPane();

        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction( e -> control.gravar() );
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction( e -> control.pesquisar() );

        paneForm.add(new Label("Id: "), 0, 0);
        paneForm.add(lblId, 1, 0);
        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);
        paneForm.add(new Label("Email: "), 0, 2);
        paneForm.add(txtEmail, 1, 2);
        paneForm.add(new Label("Telefone: "), 0, 3);
        paneForm.add(txtTelefone, 1, 3);
        paneForm.add(new Label("Nascimento: "), 0, 4);
        paneForm.add(dateNascimento, 1, 4);

        paneForm.add(btnGravar, 0, 5);
        paneForm.add(btnPesquisar, 1, 5);

        ligacoes();
        gerarColunas();

        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter(tableView);

        Scene scn = new Scene(panePrincipal, 600, 400);
        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public void gerarColunas() { 
        TableColumn<Contato, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<Contato, Long>("id") );

        TableColumn<Contato, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory( new PropertyValueFactory<Contato, String>("nome"));

        TableColumn<Contato, String> col3 = new TableColumn<>("Email");
        col3.setCellValueFactory( new PropertyValueFactory<Contato, String>("email"));

        TableColumn<Contato, String> col4 = new TableColumn<>("Telefone");
        col4.setCellValueFactory( new PropertyValueFactory<Contato, String>("telefone"));

        TableColumn<Contato, LocalDate> col5 = new TableColumn<>("Nascimento");
        col5.setCellValueFactory( new PropertyValueFactory<Contato, LocalDate>("nascimento"));
        // col5.setCellValueFactory( item -> new ReadOnlyStringWrapper( 
        //     item.getValue().getNascimento().toString() ) );

        tableView.getColumns().addAll(col1, col2, col3, col4, col5);
        tableView.setItems( control.getLista() );
    }

    public void ligacoes() { 
        control.idProperty().addListener( (obs, antigo, novo) -> {
            lblId.setText( String.valueOf(novo) );
        });
        Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
        Bindings.bindBidirectional(control.emailProperty(), txtEmail.textProperty());
        Bindings.bindBidirectional(control.telefoneProperty(), txtTelefone.textProperty());
        Bindings.bindBidirectional(control.nascimentoProperty(), 
                dateNascimento.valueProperty());
    }

    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }
    
}
