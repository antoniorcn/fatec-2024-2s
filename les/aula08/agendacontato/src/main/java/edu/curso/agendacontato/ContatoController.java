package edu.curso.agendacontato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Controller
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    private List<Contato> lista = new ArrayList<>();

    @GetMapping("/contatos")
    public ModelAndView contatos() { 
        ModelAndView mv = new ModelAndView("contatos_form");
        mv.addObject("lista", lista);
        mv.addObject("contato", 
        new Contato());
        return mv;
    }

    @GetMapping("/contatos/editar/{id}")
    public ModelAndView contatoEdit(@PathVariable("id") String id) { 
        ModelAndView mv = new ModelAndView("contatos_form_erro");
        Long longId = -1L;
        try { 
            longId = Long.parseLong(id);
            Optional<Contato> optionalContato = repository.findById(longId);
            if (optionalContato.isPresent()) { 
                Contato contato = optionalContato.get();
                System.out.printf("Contato lido para editar: %s%n", contato);
                mv = new ModelAndView("contatos_form");
                mv.addObject("lista", lista);
                mv.addObject("contato", contato);
            }
        } catch(NumberFormatException e) { 
            e.printStackTrace();
        }
        return mv;
    }

    @GetMapping("/contatos/delete/{id}")
    public ModelAndView contatoDelete(@PathVariable("id") String id) { 

        Long longId = -1L;
        try { 
            longId = Long.parseLong(id);
            repository.deleteById(longId);
            lista.clear();
            lista.addAll( repository.findByNome("") );
        } catch(NumberFormatException e) { 
            e.printStackTrace();
        }

        ModelAndView mv = new ModelAndView("contatos_form");
        mv.addObject("lista", lista);
        mv.addObject("contato", 
        new Contato());
        return mv;
    }

    @PostMapping("/contatos")
    public ModelAndView contatosCreate(
        @ModelAttribute("contato") Contato contato,
        @RequestParam("acao") String acao) { 
        System.out.printf("Salvando o contato: %s %n", contato);
        if ("gravar".equals(acao)) {
            repository.save(contato);
        } else if ("pesquisar".equals(acao)) {
            lista.clear();
            lista.addAll( repository.findByNome(contato.getNome()) );
        }
        ModelAndView mv = new ModelAndView("contatos_form");
        mv.addObject("lista", lista);
        mv.addObject("contato", 
            new Contato());
        return mv;
    }
    
}
