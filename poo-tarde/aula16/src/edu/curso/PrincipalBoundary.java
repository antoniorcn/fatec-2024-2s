package edu.curso;
import java.util.HashMap;
import java.util.Map;

import edu.curso.ContatoBoundary;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;


public class PrincipalBoundary extends Application {

    private Map<String, Tela> telas = 
        new HashMap<>();

    @Override
    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();
        telas.put("contato", new ContatoBoundary());
        telas.put("endereco", new EnderecoBoundary());

        MenuBar menuBar = new MenuBar();

        Menu mnuCadastro = new Menu("Cadastro");

        MenuItem mnuContato = new MenuItem("Contato");
        MenuItem mnuEndereco = new MenuItem("Endereco");

        mnuCadastro.getItems().addAll(mnuContato, mnuEndereco);

        menuBar.getMenus().add( mnuCadastro );

        panePrincipal.setTop( menuBar );

        mnuContato.setOnAction( e -> panePrincipal.setCenter( telas.get("contato").render() ) ); 
        mnuEndereco.setOnAction( e -> panePrincipal.setCenter( telas.get("endereco").render() ) ); 
        
        Scene scn = new Scene( panePrincipal, 600, 400);
        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PrincipalBoundary.class, args);
    }
    
}
