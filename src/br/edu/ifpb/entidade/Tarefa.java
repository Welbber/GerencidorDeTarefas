package br.edu.ifpb.entidade;

import br.edu.ifpb.dao.DAOTarefa;

public class Tarefa {
	private String titulo;
	private String descricao;
	private String dataEntrega;
	private String dataCriacao;
	private Aluno aluno;
	private int cod;
	
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
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
     public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public void cadastrar() {
		DAOTarefa d = new DAOTarefa();
		d.inserir(this);
	}
	
	public void editar(){
		DAOTarefa d = new DAOTarefa();
		d.update(this);
	}
	
	public void visualizar(){
		DAOTarefa d = new DAOTarefa();
		d.visualizar(titulo);
	}
	@Override
	public String toString() {
		return "Tarefa [titulo=" + titulo + ", descricao=" + descricao + ", dataEntrega=" + dataEntrega
				+ ", dataCriacao=" + dataCriacao + ", aluno=" + aluno + "]";
	}
	
	
}
