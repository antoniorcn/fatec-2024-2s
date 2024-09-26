package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class AppBotaoOk extends Application {
    @Override
    public void start(Stage stage) { 
        BorderPane pane = new BorderPane();

        Button btnOk = new Button("Ok");
        pane.setBottom(btnOk);

        Interceptador inter = new Interceptador();
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, inter);
        pane.requestFocus();

        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste de Botão");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(AppBotaoOk.class, args);
    }
    
}
