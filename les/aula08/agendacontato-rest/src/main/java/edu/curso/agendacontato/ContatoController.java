package edu.curso.agendacontato;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoController {
    @Autowired
    ContatoRepository repository;
    @GetMapping(path="/contatos", 
        produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Contato>> contatosConsulta() { 
        System.out.println("GET /contatos acessado");
        Iterable<Contato> lista = repository.findAll();
        return ResponseEntity.ok( lista );
    }
    @PostMapping(path="/contatos", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> contatoAdicionar(@RequestBody Contato contato) {
        System.out.println("POST /contatos acessado");
        repository.save(contato);
        return ResponseEntity.ok("Ok");
    }
}
