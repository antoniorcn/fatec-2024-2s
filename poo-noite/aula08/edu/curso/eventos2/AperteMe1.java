package edu.curso.eventos2;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class AperteMe1 extends Application 
    implements EventHandler<MouseEvent>{

    private Label lblTexto = new Label("Texto");

    public void start(Stage stage) { 
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 600, 400);
        
        Button btnPress = new Button("Aperte Me");

        btnPress.addEventHandler(MouseEvent.MOUSE_PRESSED, this);

        bp.setTop(lblTexto);
        bp.setCenter(btnPress);
        stage.setScene(scn);
        stage.setTitle("Aperte-ME");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(AperteMe1.class, args);
    }

    @Override
    public void handle(MouseEvent e) { 
        lblTexto.setText("Novo texto");
    }
}
