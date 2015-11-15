package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/atualizaContato")
public class AtualizaContatoLogic implements Logica {
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaContatoLogic() {
        super();
    }


	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//pegando os parametros
		String idString = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimentoEmTexto = request.getParameter("dataNascimento");
		Date dataTratada = null;

		//convertendo dados 
		long id = Long.parseLong(idString);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataTratada = sdf.parse(dataNascimentoEmTexto);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//carregando os dados na tabela;
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataTratada);
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.atualiza(contato);

		return "contato-atualizado.jsp";
	}

}
