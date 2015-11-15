package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

 	private static final long serialVersionUID = 1L;

	
protected void service(HttpServletRequest request,
      HttpServletResponse response) 
        throws ServletException, IOException {

	
    String parametro = request.getParameter("logica");
    String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
    String pagina = null;
    //se não tiver nada na logica, deve voltar para algum lugar ou pag principal
    if(parametro == null){
    	pagina = request.getParameter("proxpag");//proxpag = proxima pagina
    		if(pagina != null){
    			request.getRequestDispatcher(pagina).forward(request, response);
    		}else
    			request.getRequestDispatcher("bemvindo.jsp").forward(request, response);
    }else if (parametro != null) {
		
	    try {
	      Class<?> classe = Class.forName(nomeDaClasse);
	      Logica logica = (Logica) classe.newInstance();
	
	      // Recebe o String após a execução da lógica
	       pagina = logica.executa(request, response);
	
	      // Faz o forward para a página JSP
	      request.getRequestDispatcher(pagina).forward(request, response);
	
	    } catch (Exception e) {
	      throw new ServletException(
	          "A lógica de negócios causou uma exceção", e);
	    }
    }
  }
}