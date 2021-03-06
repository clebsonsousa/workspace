package br.com.caelum.tarefas.modelo;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Tarefa {
	  private Long id;
	  
	  @NotNull(message="A descri��o deve ser preenchida")  
	  @Size(min=5, message="Descri��o deve ter pelo menos 5 carateres")
	  private String descricao;
	  
	  private boolean finalizado;
	  private Date dataFinalizacao;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Date date) {
		this.dataFinalizacao = date;
	}
}
