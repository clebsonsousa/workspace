package br.com.caelum.jdbc.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;


public class ContatoDao {
	Connection connection;
	
	public ContatoDao(){
		 connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "insert into contatos "
				+ "(nome,email,endereco,dataNascimento) values "
				+ "(?,?,?,?)";
		try{
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 
			 stmt.setString(1,contato.getNome());
			 stmt.setString(2,contato.getEmail());
			 stmt.setString(3,contato.getEndereco());
			 stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));
			 
			 stmt.execute();
			 stmt.close();
			 
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		String sql = "select * from contatos";
	
		try{
			 List<Contato> contatos = new ArrayList<Contato>();
 			 PreparedStatement stmt = connection.prepareStatement(sql);
			 ResultSet result = stmt.executeQuery();
			 
			 while(result.next()){
				 Contato contato = new Contato();
				 contato.setId(result.getLong("id"));
				 contato.setNome(result.getString("nome"));
				 contato.setEmail(result.getString("email"));
				 contato.setEndereco(result.getString("endereco"));
				 Calendar data = Calendar.getInstance();
				 data.setTime(result.getDate("dataNascimento"));
				 contato.setDataNascimento(data);
				
				 contatos.add(contato);
			 }
			 result.close();
			 stmt.close();
			return contatos;

		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza(Contato contato){
		String sql = "update contatos set nome=? where id=?";
		
		try{
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 stmt.setString(1,contato.getNome());
			 stmt.setLong(2,contato.getId());

		 	 boolean result = stmt.execute();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	public void remove(Contato contato){
		String sql = "delete from contatos where id=?";
		try{
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1,contato.getId());
				stmt.execute();
				
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
