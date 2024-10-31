package edu.curso.agendacontato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contatos")
public class Contato {
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Contato() { 
        this(0L, "", "", "");
    }

    public Contato(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="nome", length=50)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name="telefone", length=20)
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name="email", length=100)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   

    
}
