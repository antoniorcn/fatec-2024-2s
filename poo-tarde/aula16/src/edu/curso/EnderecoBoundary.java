package edu.curso;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EnderecoBoundary implements Tela { 
    private Label lblId = new Label("");
    private TextField txtLogradouro = new TextField("");
    private TextField txtNumero = new TextField("");
    private TextField txtComplemento = new TextField("");
    private TextField txtBairro = new TextField("");
    private TextField txtCidade = new TextField("");
    private TextField txtEstado = new TextField("");
    private TextField txtCep = new TextField("");
    

    private TableView<Endereco> tableView = new TableView<>();

    private EnderecoControl control;

    @Override
    public Pane render() { 
        BorderPane panePrincipal = new BorderPane();

        control = new EnderecoControl();

        GridPane paneForm = new GridPane();
        paneForm.add(new Label("Id: "), 0, 0);
        paneForm.add(lblId, 1, 0);
        paneForm.add(new Label("Logradouro: "), 0, 1);
        paneForm.add(txtLogradouro, 1, 1);
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
        paneForm.add(new Label("CEP: "), 0, 7);
        paneForm.add(txtCep, 1, 7);

        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction( e -> {
            try { 
                control.gravar();
                tableView.refresh();
            } catch (AgendaException err) { 
                alert(AlertType.ERROR, "Erro ao gravar");
            }  
        });
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction( e -> { 
            try { 
                control.pesquisarPorLogradouro(); 
            } catch (AgendaException err) { 
                alert(AlertType.ERROR, "Erro ao pesquisar");
            }   
        });

        Button btnLimpar = new Button("*");
        btnLimpar.setOnAction( e -> control.limparTudo() );

        paneForm.add(btnGravar, 0, 5);
        paneForm.add(btnPesquisar, 1, 5);
        paneForm.add(btnLimpar, 2, 0);

        generateColumns();
        vincularPropriedades();

        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter(tableView);

        try { 
        control.pesquisarTodos();
        } catch(AgendaException e) { 
            alert(AlertType.ERROR, "Erro ao pesquisar todos");
        }

        return panePrincipal;
    }

    public void alert(AlertType tipo, String msg) { 
        Alert alertWindow = new Alert(tipo);
        alertWindow.setHeaderText("Alerta");
        alertWindow.setContentText(msg);
        alertWindow.showAndWait();
    }

    public void generateColumns() { 
        TableColumn<Endereco, Integer> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory(new PropertyValueFactory<Endereco, Integer>("id"));

        TableColumn<Endereco, String> col2 = new TableColumn<>("Logradouro");
        col2.setCellValueFactory(new PropertyValueFactory<Endereco, String>("logradouro"));

        TableColumn<Endereco, Integer> col3 = new TableColumn<>("Numero");
        col3.setCellValueFactory(new PropertyValueFactory<Endereco, Integer>("numero"));

        TableColumn<Endereco, String> col4 = new TableColumn<>("Complemento");
        col4.setCellValueFactory(new PropertyValueFactory<Endereco, String>("complemento"));

        TableColumn<Endereco, String> col5 = new TableColumn<>("Bairro");
        col5.setCellValueFactory(new PropertyValueFactory<Endereco, String>("bairro"));

        TableColumn<Endereco, String> col6 = new TableColumn<>("Cidade");
        col6.setCellValueFactory(new PropertyValueFactory<Endereco, String>("cidade"));

        TableColumn<Endereco, String> col7 = new TableColumn<>("Estado");
        col7.setCellValueFactory(new PropertyValueFactory<Endereco, String>("estado"));

        TableColumn<Endereco, String> col8 = new TableColumn<>("Cep");
        col8.setCellValueFactory(new PropertyValueFactory<Endereco, String>("cep"));


        // Criar o fabricante da Celula
        Callback<TableColumn<Endereco, Void>, TableCell<Endereco, Void>> callback = 
            new  Callback<>() {
                @Override
                public TableCell<Endereco, Void> call(TableColumn<Endereco, Void> param) {
                    TableCell<Endereco, Void> tc = new TableCell<>() { 
                        final Button btnExcluir = new Button("Apagar");
                        {
                            btnExcluir.setOnAction( 
                                e -> { 
                                    try { 
                                        Endereco c = tableView.getItems().get( getIndex() );
                                        control.excluir( c ); 
                                    } catch (AgendaException err) { 
                                        alert(AlertType.ERROR, "Erro ao excluir");
                                    }  
                                }
                            );
                        }
                        public void updateItem(Void item, boolean empty) { 
                            super.updateItem(item, empty);
                            if (empty) { 
                                setGraphic( null );
                            } else { 
                                setGraphic( btnExcluir );
                            }
                        }
                    };
                    return tc;
                } 
        };

        TableColumn<Endereco, Void> col9 = new TableColumn<>("Ações");
        col9.setCellFactory( callback );

        tableView.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);
        tableView.setItems( control.getLista() );

        tableView.getSelectionModel().selectedItemProperty()
        .addListener( (obs, antigo, novo) -> { 
            System.out.println( "Selecionado o contato ==> " + novo);
            control.entidadeParaTela( novo );
        });
    }

    public void vincularPropriedades() { 
        Bindings.bindBidirectional(lblId.textProperty(), control.idProperty(), 
                    (StringConverter) new LongStringConverter());
        Bindings.bindBidirectional(txtLogradouro.textProperty(), control.logradouroProperty());
        Bindings.bindBidirectional(txtNumero.textProperty(), control.numeroProperty(), 
                    (StringConverter) new IntegerStringConverter());
        Bindings.bindBidirectional(txtComplemento.textProperty(), control.complementoProperty());                    
        Bindings.bindBidirectional(txtBairro.textProperty(), control.bairroProperty());
        Bindings.bindBidirectional(txtCidade.textProperty(), control.cidadeProperty());
        Bindings.bindBidirectional(txtEstado.textProperty(), control.estadoProperty());
        Bindings.bindBidirectional(txtCep.textProperty(), control.cepProperty());
    }
}