package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;


public class RemoveContatoLogic implements Logica {

	public RemoveContatoLogic() {
        super();
    }

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//pegando os parametros
		String idString = request.getParameter("id");
		long id = Long.parseLong(idString);
		//removendo os dados na tabela;
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.remove(contato);

		return "contato-removido.jsp";
	}

}
