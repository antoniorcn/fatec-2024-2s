package interfaces;

import java.util.ArrayList;
import java.util.List;

public class Uber {
    private List<BomMotorista> lista = new ArrayList<>();
    public void contratar(BomMotorista m) { 
        lista.add(m);
    }
    public void prestarServico() { 
        for (BomMotorista motorista : lista) { 
            System.out.println("================================");
            motorista.abrirPorta();
            motorista.dirigir();
            motorista.cobrar();
        }
    }
    

    public static void main(String[] args) {
        Uber uber = new Uber();
        
        EstudanteFatec es1 = new EstudanteFatec();
        EstudanteFatec es2 = new EstudanteFatec();
        EstudanteFatecAutonomo esa1 = new EstudanteFatecAutonomo();
        EstudanteFatecAutonomo esa2 = new EstudanteFatecAutonomo();
        Entregador ent1 = new Entregador();
        Entregador ent2 = new Entregador();
        EntregadorAutonomo enta1 = new EntregadorAutonomo();
        EntregadorAutonomo enta2 = new EntregadorAutonomo();

        uber.contratar(esa1);
        uber.contratar(esa2);
        uber.contratar(enta1);
        uber.contratar(enta2);

        uber.prestarServico();

    }
}
