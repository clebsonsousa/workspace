package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	
	  @RequestMapping("novaTarefa")
	  public String form() {
	    return "tarefas/formulario";
	  }

	  @RequestMapping("adicionaTarefa")
	  public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		  
	  if(result.hasErrors()) {
		    return "tarefas/formulario";
		  }

	  	JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefas/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		List<Tarefa> tarefas = dao.lista();

		model.addAttribute("tarefas", tarefas);
		return "tarefas/lista";
	}
}
 