package edu.curso.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Interceptador 
    implements EventHandler<MouseEvent>{
        public void handle(MouseEvent e) { 
            System.out.println("Botao do mouse pressionado");
        }   
}
