package edu.curso.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Interceptador 
    implements EventHandler<MouseEvent>{

        private Label lblASerMudado;

        public void setLabelASerMudado(Label valor) { 
            this.lblASerMudado = valor;
        }

        public void handle(MouseEvent e) { 
            System.out.println("Botao do mouse pressionado");
            lblASerMudado.setText("Texto do Label Trocado...");
        }   
}
