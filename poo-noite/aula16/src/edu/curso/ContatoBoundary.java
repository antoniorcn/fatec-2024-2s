package edu.curso;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ContatoBoundary implements Tela {

    private Label lblId = new Label("");
    private TextField txtNome = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtTelefone = new TextField();
    private DatePicker dateNascimento = new DatePicker();

    private ContatoControl control = null;

    private TableView<Contato> tableView = new TableView<>();

    @Override
    public Pane render() {
        try { 
            control = new ContatoControl();
        } catch (AgendaException e ) { 
            new Alert(AlertType.ERROR, "Erro ao iniciar o sistema", ButtonType.OK).showAndWait();
        }
        BorderPane panePrincipal = new BorderPane();
        GridPane paneForm = new GridPane();

        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction( e -> { 
            try { 
                control.gravar();
            } catch (AgendaException err) { 
                new Alert(AlertType.ERROR, "Erro ao gravar o contato", ButtonType.OK).showAndWait();
            }
            tableView.refresh();
        });
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction( e -> { 
            try { 
                control.pesquisar();
            } catch (AgendaException err) { 
                new Alert(AlertType.ERROR, "Erro ao pesquisar por nome", ButtonType.OK).showAndWait();
            }});

        Button btnNovo = new Button("*");
        btnNovo.setOnAction( e -> control.limparTudo() );

        paneForm.add(new Label("Id: "), 0, 0);
        paneForm.add(lblId, 1, 0);
        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);
        paneForm.add(btnNovo, 2, 1);
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

        return panePrincipal;
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

        tableView.getSelectionModel().selectedItemProperty()
            .addListener( (obs, antigo, novo) -> {
                if (novo != null) { 
                    System.out.println("Nome: " + novo.getNome());
                    control.paraTela(novo);
                }
            });
        Callback<TableColumn<Contato, Void>, TableCell<Contato, Void>> cb = 
            new Callback<>() {
                @Override
                public TableCell<Contato, Void> call(
                    TableColumn<Contato, Void> param) {
                    TableCell<Contato, Void> celula = new TableCell<>() { 
                        final Button btnApagar = new Button("Apagar");

                        {
                            btnApagar.setOnAction( e -> {
                                Contato contato = tableView.getItems().get( getIndex() );
                                try { 
                                    control.excluir( contato ); 
                                } catch (AgendaException err) { 
                                    new Alert(AlertType.ERROR, "Erro ao excluir o contato", ButtonType.OK).showAndWait();
                                }
                            });
                        }

                        @Override
                        public void updateItem( Void item, boolean empty) {                             
                            if (!empty) { 
                                setGraphic(btnApagar);
                            } else { 
                                setGraphic(null);
                            }
                        }
                        
                    };
                    return celula;            
                } 
            };

        TableColumn<Contato, Void> col6 = new TableColumn<>("Ação");
        col6.setCellFactory(cb);

        tableView.getColumns().addAll(col1, col2, col3, col4, col5, col6);
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
}
