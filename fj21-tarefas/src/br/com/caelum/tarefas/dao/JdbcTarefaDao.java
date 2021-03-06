package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.caelum.tarefas.jdbc.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Tarefa;

public class JdbcTarefaDao {
	Connection connection;
	
	public JdbcTarefaDao(){
		 connection = new ConnectionFactory().getConnection();
	}

	public void adiciona( Tarefa tarefa) {
		String sql = "insert into tarefas "
				+ "(descricao,finalizado,dataFinalizacao) values "
				+ "(?,?,?)";
		try{
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 
			 stmt.setString(1,tarefa.getDescricao());
			 stmt.setBoolean(2,tarefa.isFinalizado());
			 stmt.setDate(3,new Date(System.currentTimeMillis()));
			 
			 stmt.execute();
			 stmt.close();
			 
		}catch(SQLException e){
			throw new RuntimeException(e);
		}

	}

	public List<Tarefa> lista() {
		
		String sql = "select * from tarefas";
		
		try{
			 List<Tarefa> tarefas = new ArrayList<Tarefa>();
 			 PreparedStatement stmt = connection.prepareStatement(sql);
			 ResultSet result = stmt.executeQuery();
			 
			 while(result.next()){
				 Tarefa tarefa = new Tarefa();
				 tarefa.setId(result.getLong("id"));
				 tarefa.setDescricao(result.getString("descricao"));
				 tarefa.setFinalizado(result.getBoolean("finalizado"));
				 tarefa.setDataFinalizacao(result.getDate("dataFinalizacao"));
				
				 tarefas.add(tarefa);
			 }
			 result.close();
			 stmt.close();
			return tarefas;

		}catch(SQLException e){
			throw new RuntimeException(e);
		}

		
	}

}
