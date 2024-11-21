package edu.curso;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EnderecoControl {

    private LongProperty id = new SimpleLongProperty(0l);
    private StringProperty logradouro = new SimpleStringProperty("");
    private IntegerProperty numero = new SimpleIntegerProperty(0);
    private StringProperty complemento = new SimpleStringProperty("");
    private StringProperty bairro = new SimpleStringProperty("");
    private StringProperty cidade = new SimpleStringProperty("");
    private StringProperty estado = new SimpleStringProperty("");
    private StringProperty cep = new SimpleStringProperty("");

    private ObservableList<Endereco> lista = FXCollections.observableArrayList();

    private EnderecoDAO enderecoDAO;

    private int contador = 0;

    public EnderecoControl() throws AgendaException { 
        enderecoDAO = new EnderecoDAOImpl();
    }

    public void excluir( Endereco c ) throws AgendaException { 
        enderecoDAO.remover( c );
        pesquisarTodos();
    }

    public void gravar() throws AgendaException {
        Endereco endereco = telaParaEntidade();
        if (id.get() == 0) { 
            endereco.setId(++contador);
            enderecoDAO.inserir(endereco);
        } else { 
            enderecoDAO.atualizar(endereco);
        }
        limparTudo();
        pesquisarTodos();
    }

    public void pesquisar() throws AgendaException { 
        List<Endereco> listaTemp = enderecoDAO.pesquisarPorLogradouro( logradouro.get() );
        lista.clear();
        lista.addAll( listaTemp );
    }

    public void pesquisarTodos() throws AgendaException { 
        List<Endereco> listaTemp = enderecoDAO.pesquisarPorLogradouro( "" );
        lista.clear();
        lista.addAll( listaTemp );
    }

    public void limparTudo() { 
        id.set(0l);
        logradouro.set("");
        numero.set(0);
        complemento.set("");
        bairro.set("");
        cidade.set("");
        estado.set("");
        cep.set("");
    }

    public void entidadeParaTela(Endereco e) { 
        id.set(e.getId());
        logradouro.set(e.getLogradouro());
        numero.set(e.getNumero());
        complemento.set(e.getComplemento());
        bairro.set(e.getBairro());
        cidade.set(e.getCidade());
        estado.set(e.getEstado());
        cep.set(e.getCep());
    }

    public Endereco telaParaEntidade() { 
        Endereco endereco = new Endereco();
        endereco.setId(id.get());
        endereco.setLogradouro(logradouro.get());
        endereco.setNumero(numero.get());
        endereco.setComplemento(complemento.get());
        endereco.setBairro(bairro.get());
        endereco.setCidade(cidade.get());
        endereco.setEstado(estado.get());
        endereco.setCep(cep.get());
        return endereco;
    }

    public LongProperty idProperty() { 
        return this.id;
    }
    public StringProperty logradouroProperty() { 
        return this.logradouro;
    }
    public IntegerProperty numeroProperty() { 
        return this.numero;
    }
    public StringProperty complementoProperty() { 
        return this.complemento;
    }
    public StringProperty bairroProperty() { 
        return this.bairro;
    }
    public StringProperty cidadeProperty() { 
        return this.cidade;
    }
    public StringProperty estadoProperty() { 
        return this.estado;
    }
    public StringProperty cepProperty() { 
        return this.cep;
    }    
}
