
import edu.curso.Pagamentos;
import edu.curso.Trabalhador;

public class PagamentoMelhor extends Pagamentos { 

    @Override
    public void fazPagamento(Trabalhador t) { 
        double total = t.getHoras() * 30.0 + 100.0;
        t.receberSalario(total);
    }

}