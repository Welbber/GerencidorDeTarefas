package br.edu.ifpb.dao;

import java.util.List;

import br.edu.ifpb.exception.GerenciadorTarefasSqlException;

public interface DAOInterface <T>{
	public int creat(T t) throws GerenciadorTarefasSqlException;
	public int update(T t) throws GerenciadorTarefasSqlException;
	public List<T> listarTodos() throws GerenciadorTarefasSqlException;
	public int delete(T t) throws GerenciadorTarefasSqlException;
}