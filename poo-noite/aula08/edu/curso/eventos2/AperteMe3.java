package edu.curso.eventos2;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class AperteMe3 extends Application {

    public void start(Stage stage) { 
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 600, 400);
        Label lblTexto = new Label("Texto");        
        Button btnPress = new Button("Aperte Me");


        btnPress.addEventHandler(MouseEvent.MOUSE_PRESSED,
            (MouseEvent e) -> { 
                lblTexto.setText("Label modificado V3"); 
            }
        );

        bp.setTop(lblTexto);
        bp.setCenter(btnPress);
        stage.setScene(scn);
        stage.setTitle("Aperte-ME");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(AperteMe3.class, args);
    }
}
