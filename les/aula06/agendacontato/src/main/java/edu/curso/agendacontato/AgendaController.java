package edu.curso.agendacontato;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AgendaController {

    private List<Contato> lista = new ArrayList<>();

    public ModelAndView generateModelAndView( String viewName ){ 
        Contato c1 = new Contato("", 
        "", "");
        ModelAndView mv = new ModelAndView("agenda");
        mv.addObject("contato", c1);
        mv.addObject("lista", lista);
        return mv;
    }

    @GetMapping("/agenda")
    public ModelAndView contato() { 
        return generateModelAndView("agenda");
    }

    @PostMapping("/agenda")
    public ModelAndView contatoSubmit(@ModelAttribute Contato contato,
    @RequestParam("acao") String acao) {
        System.out.println("Ação: " + acao);
        if ("gravar".equals(acao)) {
            lista.add(contato);
        }
        System.out.println("Lista: " + lista);
        // Contato c1 = new Contato("", 
        // "", "");
        // ModelAndView mv = new ModelAndView("agenda");
        // mv.addObject("contato", c1);
        // mv.addObject("lista", lista);
        // return mv;
        return generateModelAndView("agenda");
    }
}
