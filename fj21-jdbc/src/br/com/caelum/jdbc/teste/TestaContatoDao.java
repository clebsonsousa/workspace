package br.com.caelum.jdbc.teste;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaContatoDao {

	public static void main(String[] args) {
		
		listaContato();
		//adicionaContato();
		//atualizaContato();
		//removeContato();
	}

	


	public static void adicionaContato(){
		Contato contato = new Contato();
		contato.setNome("Teste Nome 2");
		contato.setEmail("Teste Email 2");
		contato.setEndereco("Teste Endereco 2");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		System.out.println("Contato Adicionado!");
	}

	public static void listaContato(){
		ContatoDao dao = new ContatoDao();
        
		List<Contato> contatos = dao.getLista();
		
		for(Contato contato: contatos ){
			System.out.println("Nome: "+ contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de nascimento: " + contato.getDataNascimento().getTime() + "\n");
		}
		
		System.out.println("Temos " + contatos.size() + " contato(s) Listado(s)!");

	}
	
	public static void atualizaContato(){

		Contato contato = new Contato();
		contato.setId((long)1);
		contato.setNome("Teste Clebson 4");
		ContatoDao dao = new ContatoDao();
		dao.atualiza(contato);
		System.out.println("contato Atualizado com sucesso");
	}

	private static void removeContato() {

		Contato contato = new Contato();
		contato.setId((long)6);
		ContatoDao dao = new ContatoDao();
		dao.remove(contato);
		System.out.println("Contato Removido!");

	}


}
