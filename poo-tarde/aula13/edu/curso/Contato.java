package edu.curso;
import java.time.LocalDate;

public class Contato { 
    private int id = 0;
    private String nome = "";
    private String telefone = "";
    private String email = "";
    private LocalDate nascimento = LocalDate.now();
    
    public int getId() { 
        return this.id;
    }
    public void setId(int valor) { 
        this.id=valor;
    }

    public String getNome() { 
        return this.nome;
    }
    public void setNome(String valor) { 
        this.nome=valor;
    }

    public String getEmail() { 
        return this.email;
    }
    public void setEmail(String valor) { 
        this.email=valor;
    }

    public String getTelefone() { 
        return this.telefone;
    }
    public void setTelefone(String valor) { 
        this.telefone=valor;
    }

    public LocalDate getNascimento() { 
        return this.nascimento;
    }
    public void setNascimento(LocalDate valor) { 
        this.nascimento=valor;
    }
}