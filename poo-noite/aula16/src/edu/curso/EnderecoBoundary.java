package edu.curso;

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
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class EnderecoBoundary extends Application {

    private Label lblId = new Label("");
    private TextField txtLogradouro = new TextField();
    private TextField txtNumero = new TextField();
    private TextField txtComplemento = new TextField();
    private TextField txtBairro = new TextField();
    private TextField txtCidade = new TextField();
    private TextField txtEstado = new TextField();
    private TextField txtCep = new TextField();

    private EnderecoControl control = null;

    private TableView<Endereco> tableView = new TableView<>();

    @Override
    public void start(Stage stage) {
        try { 
            control = new EnderecoControl();
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
        paneForm.add(new Label("Logradouro: "), 0, 1);
        paneForm.add(txtLogradouro, 1, 1);
        paneForm.add(btnNovo, 2, 1);
        paneForm.add(new Label("Numero: "), 0, 2);
        paneForm.add(txtNumero, 1, 2);
        paneForm.add(new Label("Complemento: "), 0, 3);
        paneForm.add(txtComplemento, 1, 3);
        paneForm.add(new Label("Bairro: "), 0, 4);
        paneForm.add(txtBairro, 1, 4);
        paneForm.add(new Label("Cidade: "), 0, 5);
        paneForm.add(txtCidade, 1, 5);
        paneForm.add(new Label("Estado: "), 0, 6);
        paneForm.add(txtEstado, 1, 6);
        paneForm.add(new Label("Cep: "), 0, 7);
        paneForm.add(txtCep, 1, 7);

        paneForm.add(btnGravar, 0, 8);
        paneForm.add(btnPesquisar, 1, 8);

        ligacoes();
        gerarColunas();

        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter(tableView);

        Scene scn = new Scene(panePrincipal, 600, 400);
        stage.setScene(scn);
        stage.setTitle("Gestão de Endereços");
        stage.show();
    }

    public void gerarColunas() { 
        TableColumn<Endereco, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<Endereco, Long>("id") );

        TableColumn<Endereco, String> col2 = new TableColumn<>("Logradouro");
        col2.setCellValueFactory( new PropertyValueFactory<Endereco, String>("logradouro"));

        TableColumn<Endereco, Integer> col3 = new TableColumn<>("Número");
        col3.setCellValueFactory( new PropertyValueFactory<Endereco, Integer>("numero"));

        TableColumn<Endereco, String> col4 = new TableColumn<>("Complemento");
        col4.setCellValueFactory( new PropertyValueFactory<Endereco, String>("complemento"));

        TableColumn<Endereco, String> col5 = new TableColumn<>("Bairro");
        col5.setCellValueFactory( new PropertyValueFactory<Endereco, String>("bairro"));

        TableColumn<Endereco, String> col6 = new TableColumn<>("Cidade");
        col6.setCellValueFactory( new PropertyValueFactory<Endereco, String>("cidade"));

        TableColumn<Endereco, String> col7 = new TableColumn<>("Estado");
        col7.setCellValueFactory( new PropertyValueFactory<Endereco, String>("estado"));

        TableColumn<Endereco, String> col8 = new TableColumn<>("Cep");
        col8.setCellValueFactory( new PropertyValueFactory<Endereco, String>("cep"));


        tableView.getSelectionModel().selectedItemProperty()
            .addListener( (obs, antigo, novo) -> {
                if (novo != null) { 
                    System.out.println("Logradouro: " + novo.getLogradouro());
                    control.entidadeParaTela(novo);
                }
            });
        Callback<TableColumn<Endereco, Void>, TableCell<Endereco, Void>> cb = 
            new Callback<>() {
                @Override
                public TableCell<Endereco, Void> call(
                    TableColumn<Endereco, Void> param) {
                    TableCell<Endereco, Void> celula = new TableCell<>() { 
                        final Button btnApagar = new Button("Apagar");

                        {
                            btnApagar.setOnAction( e -> {
                                Endereco endereco = tableView.getItems().get( getIndex() );
                                try { 
                                    control.excluir( endereco ); 
                                } catch (AgendaException err) { 
                                    new Alert(AlertType.ERROR, "Erro ao excluir o endereco", ButtonType.OK).showAndWait();
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

        TableColumn<Endereco, Void> col9 = new TableColumn<>("Ação");
        col9.setCellFactory(cb);

        tableView.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);
        tableView.setItems( control.getLista() );
    }

    public void ligacoes() { 
        control.idProperty().addListener( (obs, antigo, novo) -> {
            lblId.setText( String.valueOf(novo) );
        });

        IntegerStringConverter integerConverter = new IntegerStringConverter();
        Bindings.bindBidirectional(control.logradouroProperty(), txtLogradouro.textProperty());
        Bindings.bindBidirectional(txtNumero.textProperty(), control.numeroProperty(), (StringConverter) integerConverter);
        Bindings.bindBidirectional(control.complementoProperty(), txtComplemento.textProperty());
        Bindings.bindBidirectional(control.bairroProperty(), txtBairro.textProperty() );
        Bindings.bindBidirectional(control.cidadeProperty(), txtCidade.textProperty() );
        Bindings.bindBidirectional(control.estadoProperty(), txtEstado.textProperty() );
        Bindings.bindBidirectional(control.cepProperty(), txtCep.textProperty() );
    }

    public static void main(String[] args) {
        Application.launch(EnderecoBoundary.class, args);
    }
    
}
