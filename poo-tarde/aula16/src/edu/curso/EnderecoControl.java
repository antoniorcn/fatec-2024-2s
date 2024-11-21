package edu.curso;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.curso.AgendaException;
import edu.curso.EnderecoDAOImpl;

public class EnderecoControl {

    private ObservableList<Endereco> lista = FXCollections.observableArrayList();
    private LongProperty id = new SimpleLongProperty(0l);
    private StringProperty logradouro = new SimpleStringProperty("");
    private IntegerProperty numero = new SimpleIntegerProperty(0);
    private StringProperty complemento = new SimpleStringProperty("");
    private StringProperty bairro = new SimpleStringProperty("");
    private StringProperty cidade = new SimpleStringProperty("");
    private StringProperty estado = new SimpleStringProperty("");
    private StringProperty cep = new SimpleStringProperty("");

    private EnderecoDAO enderecoDAO = new EnderecoDAOImpl();

    private Long contador = 0l;

    public void limparTudo() { 
        id.set(0);
        logradouro.set("");
        numero.set(0);
        complemento.set("");
        bairro.set("");
        cidade.set("");
        estado.set("");
        cep.set("");
    }


    public void entidadeParaTela(Endereco e) { 
        if (e != null) { 
            id.set( e.getId() );
            logradouro.set( e.getLogradouro() );
            numero.set( e.getNumero() );
            complemento.set( e.getComplemento() );
            bairro.set( e.getBairro() );
            cidade.set( e.getCidade() );
            estado.set( e.getEstado() );
            cep.set( e.getCep() );
        }
    }

    public void pesquisarTodos() throws AgendaException { 
        List<Endereco> tempLista = enderecoDAO.pesquisarTodos();
        lista.clear();
        lista.addAll(tempLista);
    }

    public void pesquisarPorLogradouro() throws AgendaException { 
        List<Endereco> tempLista = 
                enderecoDAO.pesquisarPorLogradouro( logradouro.get() );
        lista.clear();
        lista.addAll(tempLista);
    }

    public void gravar() throws AgendaException { 
        Endereco endereco = new Endereco();
        endereco.setLogradouro( logradouro.get() );
        endereco.setNumero( numero.get() );
        endereco.setComplemento( complemento.get() );
        endereco.setBairro( bairro.get() );
        endereco.setCidade( cidade.get() );
        endereco.setEstado( estado.get() );
        endereco.setCep( cep.get() );
        if (id.get() == 0)  {
            endereco.setId( contador++ );
            enderecoDAO.inserir(endereco);
        } else { 
            endereco.setId( id.get() );
            enderecoDAO.atualizar(endereco);
        }
        pesquisarTodos();
        limparTudo();
    }

    public void excluir(Endereco endereco) throws AgendaException { 
        enderecoDAO.excluir(endereco);
        pesquisarTodos();
    }

    public ObservableList<Endereco> getLista() { 
        return this.lista;
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
    public StringProperty bairroProperty() { 
        return this.bairro;
    }
    public StringProperty complementoProperty() { 
        return this.complemento;
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
