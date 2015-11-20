package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
