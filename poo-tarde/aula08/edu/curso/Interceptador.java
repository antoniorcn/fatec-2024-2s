package edu.curso;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Interceptador 
        implements EventHandler<ActionEvent> {

    private Stage stage;

    public void setStage(Stage stage) { 
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Botão apertado ... ");

        if (stage != null) { 
            stage.setTitle("Botão foi apertado");
        }
    }
}
