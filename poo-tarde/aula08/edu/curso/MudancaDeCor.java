package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class MudancaDeCor extends Application {

    private int vermelho = 0;
    private int azul = 0; 

    @Override
    public void start(Stage stage) { 
        BorderPane pane = new BorderPane();
        Pane painelCor = new Pane();

        Button btnVermelho = new Button("Aumentar Vermelho");
        btnVermelho.setOnAction( e-> {
            this.vermelho += 10;
            if  (this.vermelho > 255) { 
                this.vermelho = 255;
            }
            BackgroundFill backgroundFill = new BackgroundFill( 
                Color.rgb(vermelho, 0, azul), 
                new CornerRadii(10), 
                new Insets(10) );
            painelCor.setBackground(new Background(backgroundFill) );
        });
        Button btnAzul = new Button("Aumentar Azul");
        
        pane.setTop(btnVermelho);
        pane.setBottom(btnAzul);
        pane.setCenter(painelCor);

        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Troca cor do painel");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(MudancaDeCor.class, args);
    }
    
}
