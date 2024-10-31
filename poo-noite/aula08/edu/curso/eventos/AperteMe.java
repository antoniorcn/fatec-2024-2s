package edu.curso.eventos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class AperteMe extends Application {
    public void start(Stage stage) { 
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 600, 400);

        Label lblTexto = new Label("Texto");

        Button btnPress = new Button("Aperte Me");

        Interceptador inter1 = new Interceptador();
        inter1.setLabelASerMudado(lblTexto);
        btnPress.addEventHandler(MouseEvent.MOUSE_PRESSED, inter1);

        bp.setTop(lblTexto);
        bp.setCenter(btnPress);
        stage.setScene(scn);
        stage.setTitle("Aperte-ME");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(AperteMe.class, args);
    }
}
