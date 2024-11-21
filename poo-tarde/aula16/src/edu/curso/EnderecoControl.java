import java.time.LocalDate;

import javafx.beans.property.*;

public class EnderecoControl {

    ObservableList<Endereco> lista = FXCollections.observableArrayList();
    LongProperty id = new SimpleLongProperty(0l);
    StringProperty logradouro = new SimpleStringProperty("");
    IntegerProperty numero = new SimpleIntegerProperty("");
    StringProperty complemento = new SimpleStringProperty("");
    StringProperty bairro = new SimpleStringProperty("");
    StringProperty cidade = new SimpleStringProperty("");
    StringProperty estado = new SimpleStringProperty("");
    StringProperty cep = new SimpleStringProperty("");


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


    public LongProperty idProperty() { 
        return this.id;
    }
    public StringProperty logradouroProperty() { 
        return this.logradouro;
    }
    public LongProperty numeroProperty() { 
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
