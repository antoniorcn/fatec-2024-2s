package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class AppBotaoOk extends Application implements 
EventHandler<ActionEvent>{

    private Stage stage;

    @Override
    public void start(Stage stage) { 
        BorderPane pane = new BorderPane();
        this.stage = stage;
        Button btnOk = new Button("Ok");
        pane.setBottom(btnOk);

        // Interceptador inter = new Interceptador();
        // inter.setStage(stage);
        // btnOk.addEventHandler(ActionEvent.ANY, inter);
        btnOk.addEventHandler(ActionEvent.ANY, this);

        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste de Botão");
        stage.show();
    }

    @Override
    public void handle(ActionEvent e) { 
        stage.setTitle("Botão foi apertado (2)");
    }

    public static void main(String[] args) {
        Application.launch(AppBotaoOk.class, args);
    }
    
}
