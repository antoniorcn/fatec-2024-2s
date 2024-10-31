package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class AppBotaoOk3 extends Application {

    @Override
    public void start(Stage stage) { 
        BorderPane pane = new BorderPane();
        Button btnOk = new Button("Ok");
        pane.setBottom(btnOk);

        EventHandler<ActionEvent> eventHand = new EventHandler<>(){
            @Override
            public void handle(ActionEvent e) { 
                stage.setTitle("Botao apertado parte (3)");
            }
        };

        btnOk.addEventHandler(ActionEvent.ANY, eventHand);

        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste de Botão");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AppBotaoOk3.class, args);
    }
    
}
