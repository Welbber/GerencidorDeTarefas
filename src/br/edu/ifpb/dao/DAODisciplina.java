package br.edu.ifpb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.entidade.Aluno;
import br.edu.ifpb.entidade.Disciplina;
import br.edu.ifpb.util.ConnectionFactory;

public class DAODisciplina {

	
	public void inserir(Disciplina d) {
		ConnectionFactory con = new ConnectionFactory();
		String sql = "select count(codigo) codigo from disciplina;";
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
		sql = "INSERT into disciplina values"+
			"("+quanti+",'"+
			d.getNome()+"',"+
			d.getTipo()+")'"+
			"INSERT into professor_disciplina values"+
			"("+1+",'"+
			quanti+"');";
	
		int res = in.executaSQL(sql);

		if(res > 0){
			System.out.println("Cadastro realizado com sucesso!");
		}else {
			System.out.println("Erro ao casdastrar!");
		}
	}
	
	public void update(Disciplina d) {
ConnectionFactory in = new ConnectionFactory();
		
		String UPDATE = "UPDATE discioplina SET "
				+ "NOME="+d.getNome() 
				+" WHERE codigo="+d.getCod();
		
		in.executaSQL(UPDATE);
	}
	
	public Disciplina visualizar(String nome){
		ConnectionFactory consulta = new ConnectionFactory();
		String SQL = "select * from disciplina where nome="+nome;
		ResultSet rs = consulta.executaBusca(SQL);
		Disciplina d = new Disciplina();
		try {
			while(rs.next()) {
				d.setCod(rs.getInt("codigo"));
				d.setNome(rs.getString("nome"));
				d.setTipo(rs.getString("tipo"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
}
