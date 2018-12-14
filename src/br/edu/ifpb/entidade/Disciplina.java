package br.edu.ifpb.entidade;

import br.edu.ifpb.dao.DAODisciplina;

public class Disciplina {
	private String nome;
	private String tipo;
	private Professor professor;
	private int cod;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public void cadastrar() {
		DAODisciplina dao = new DAODisciplina();		
		dao.inserir(this);
	}
	
	public void editar(){
		DAODisciplina dao = new DAODisciplina();		
		dao.update(this);
	}
	
	public void visualizar(){
		DAODisciplina dao = new DAODisciplina();		
		dao.visualizar(nome);
	}
	
	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", tipo=" + tipo + ", professor=" + professor + "]";
	}
	
	
	
}
