package edu.curso;
public class Contato { 
    private String nome;
    private String telefone;
    private String email;

    public String getNome() { 
        return this.nome;
    }
    public void setNome( String valor ){
        this.nome = valor;
    }

    public String getTelefone() { 
        return this.telefone;
    }
    public void setTelefone( String valor ){
        this.telefone = valor;
    }    
    
    public String getEmail() { 
        return this.email;
    }
    public void setEmail( String valor ){
        this.email = valor;
    }    

    @Override
    public String toString() { 
        return String.format("Contato(nome='%s', telefone='%s', email='%s')", 
                    this.nome, this.telefone, this.email);
    }
}