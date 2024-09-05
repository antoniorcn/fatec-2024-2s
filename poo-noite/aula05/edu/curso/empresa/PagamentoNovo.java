package edu.curso.empresa;

public class PagamentoNovo extends Pagamentos {

    
    void pagarSalario(Operario o) {
        double pagamento = o.horas * 30 + 200.0;
        o.recebeSalario(pagamento);
    }
    
}
