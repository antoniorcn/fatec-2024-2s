package edu.curso.agendacontato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoController {
    @Autowired
    ContatoRepository repository;


    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping(path="/contatos", 
        produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Contato>> contatosConsulta() { 
        System.out.println("GET /contatos acessado");
        Iterable<Contato> lista = repository.findAll();
        return ResponseEntity.ok( lista );
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping(path="/contatos", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> contatoAdicionar(@RequestBody Contato contato) {
        System.out.println("POST /contatos acessado");
        repository.save(contato);
        return ResponseEntity.ok("Ok");
    }
}
