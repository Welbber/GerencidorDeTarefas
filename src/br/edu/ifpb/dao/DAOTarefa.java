package br.edu.ifpb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.entidade.Disciplina;
import br.edu.ifpb.entidade.Tarefa;
import br.edu.ifpb.util.ConnectionFactory;

public class DAOTarefa {

	
	public void inserir(Tarefa t) {
		ConnectionFactory con = new ConnectionFactory();
		String sql = "select count(codigo) codigo from tarefa;";
		ResultSet rs = con.executaBusca(sql);
		int quanti = 1;
		try {
			while(rs.next()) {
				quanti = rs.getInt("codigo");
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(quanti);
		ConnectionFactory in = new ConnectionFactory();
		quanti++;
		sql = "INSERT into tarefa values"+
			"("+quanti+",'"+
			t.getTitulo()+"',"+
			t.getDescricao()+"',"+
			t.getDataEntrega()+"',"+
			t.getDataCriacao()+")'";
	
		int res = in.executaSQL(sql);

		if(res > 0){
			System.out.println("Cadastro realizado com sucesso!");
		}else {
			System.out.println("Erro ao casdastrar!");
		}
	}
	
	public void update(Tarefa t) {
ConnectionFactory in = new ConnectionFactory();
		
		String UPDATE = "UPDATE tarefa SET "
				+ "titulo="+t.getTitulo()
				+ "titulo="+t.getDescricao()
				+" WHERE codigo="+t.getCod();
		
		in.executaSQL(UPDATE);
	}
	
	public Tarefa visualizar(String nome){
		ConnectionFactory consulta = new ConnectionFactory();
		String SQL = "select * from tarefa where titulo="+nome;
		ResultSet rs = consulta.executaBusca(SQL);
		Tarefa t = new Tarefa();
		try {
			while(rs.next()) {
				t.setCod(rs.getInt("codigo"));
				t.setTitulo(rs.getString("titulo"));
				t.setDescricao(rs.getString("descricao"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
}
