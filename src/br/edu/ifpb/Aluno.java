package br.edu.ifpb;

import java.util.Set;

public class Aluno extends Pessoa{
	private String senha;
	private String usuario;
	public Aluno() {
	}
	public Aluno(String usuario,String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return this.senha;
	}
}
