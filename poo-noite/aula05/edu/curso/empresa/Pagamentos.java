package edu.curso.empresa;

public class Pagamentos {

    void pagarSalario( Operario o ) {
        double pagamento = o.horas * 15 + 200.0;
        o.recebeSalario(pagamento);
    }
    
}
