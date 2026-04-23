package projeto_java_com_bd;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import projeto_java_com_bd.model.Notas;
import projeto_java_com_bd.model.notasService;

@Controller
public class paginaController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")    
    public String index(){
        return "index";
    }

    @GetMapping("/pagina1")
    public String formanotacao(Model model){
        model.addAttribute("anotacao", new Notas());
        return "pagina1";
    }

    @GetMapping("/pagina2")
    public String pagina2() {
        return "pagina2";
    }

    @GetMapping("/pagina3")
    public String listarNotas(Model model){
        notasService cs = context.getBean(notasService.class);
        ArrayList<Notas> notas = (ArrayList<Notas>) cs.listarNotas();
        model.addAttribute("notas",notas);
        return "pagina3";
    }

    @PostMapping("/pagina1")
    public String postCliente(@ModelAttribute Notas notas,
                                Model model){
        notasService cs = context.getBean(notasService.class);
        cs.inserirNota(notas);
        return "redirect:/pagina1";
    }
}
