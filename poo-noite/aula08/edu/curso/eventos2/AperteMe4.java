package edu.curso.eventos2;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class AperteMe4 extends Application {

    public void start(Stage stage) { 
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 600, 400);
        Label lblTexto = new Label("Texto");        
        Button btnPress = new Button("Aperte Me");

        scn.setOnMousePressed(
            e -> e.consume()
        );


        // btnPress.setOnMousePressed(
        //     e -> lblTexto.setText("Label modificado V4")
        // );
        
        // btnPress.setOnAction(
        //     e -> lblTexto.setText("Label modificado V5")
        // );

        btnPress.setOnMouseEntered(
            e -> lblTexto.setText("Label modificado V6")
        );

        bp.setTop(lblTexto);
        bp.setCenter(btnPress);
        stage.setScene(scn);
        stage.setTitle("Aperte-ME");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(AperteMe4.class, args);
    }
}
