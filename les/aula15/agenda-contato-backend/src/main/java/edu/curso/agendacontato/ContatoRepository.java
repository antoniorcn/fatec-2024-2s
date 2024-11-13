package edu.curso.agendacontato;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long> { 
    
    @Query("select c from Contato c where c.nome like %:nome%")
    List<Contato> findByNome(@Param("nome") String nome);
    
}
