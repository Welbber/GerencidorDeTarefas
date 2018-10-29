package br.edu.ifpb.entidade;

public class Tarefa {
	private String titulo;
	private String descricao;
	private String dataEntrega;
	private String dataCriacao;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData_entrega() {
		return dataEntrega;
	}
	public void setData_entrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getData_criacao() {
		return dataCriacao;
	}
	public void setData_criacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
