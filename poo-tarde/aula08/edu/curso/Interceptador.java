package edu.curso;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Interceptador 
        implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.println("Botão apertado ... ");
    }
}
