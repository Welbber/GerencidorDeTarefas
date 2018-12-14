package br.edu.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.ifpb.entidade.Aluno;
import br.edu.ifpb.util.ConnectionFactory;

public class DAOAluno {
	public void inserirNoBanco(String nome, int matricula, String email, String telefone, String rua, 
			int numero, String complemento, String usuario, String senha, String frase, String resposta){
		ConnectionFactory con = new ConnectionFactory();
		String sql = "select count(id_pessoa) Numero from pessoa;";
		ResultSet rs = con.executaBusca(sql);
		int quanti = 1;
		try {
			while(rs.next()) {
				quanti = rs.getInt("Numero");
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(quanti);
		ConnectionFactory in = new ConnectionFactory();
		quanti++;
		sql = "INSERT into pessoa values"+
			"("+quanti+",'"+
			nome+"',"+
			matricula+",'"+
			email+"','"+
			telefone+"','"+
			rua+"',"+
			numero+",'"+
			complemento+"');"+
			"INSERT into aluno values"+
			"("+quanti+++",'"+
			usuario+"','"+
			senha+"','"+
			frase+"','"+
			resposta+"');";
	
		int res = in.executaSQL(sql);

		if(res > 0){
			System.out.println("Cadastro realizado com sucesso!");
		}else {
			System.out.println("Erro ao casdastrar!");
		}
	}
	
	//metodo responsavel pela recuperacao da conta do usuario
	public boolean recuperaSenha(String nome) {
			
		Scanner inputString = new Scanner(System.in);
			
		//variavel responsavel pela consulta no banco se existe o nome informado
		ConnectionFactory consulta = new ConnectionFactory();
		//comunicacao responsavel pela atualizacao de dados no banco
		ConnectionFactory atualiza = new ConnectionFactory();
		//comunicacao responsavel pela atualizacao da senha
		ConnectionFactory AlteraSenha = new ConnectionFactory();
			
		//comando SQL responsavel pela verificacao do nome infomrado e retorno da frase de recuperacao
		String SQL = "select p.nome, a.frase_de_recuperacao from pessoa p, aluno a where nome='"+nome+"' and a.id_aluno = p.id_pessoa;";
		ResultSet rs = consulta.executaBusca(SQL);
			
		//variavel temporaria responsavel por indicar se a consulta teve exito
		boolean aux = false;
			
		try {
			while(rs.next()) {
				System.out.println(rs.getString("frase_de_recuperacao"));
				aux = true;
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//variavel responsavel por armazenar a resposta da frase, informada pelo usuario
		String resposta = "";
		
		if(aux) {
			System.out.print("Digite a resposta: ");
			resposta = inputString.nextLine();
		}else {
			System.out.println("Nome não encontrado!");
			return false;
		}
		
		//comando SQL responsavel pela verificacao da resposta informada pelo usuario
		SQL = "select resposta_de_recuperacao from aluno where resposta_de_recuperacao='"+resposta+"';";
			
		rs = atualiza.executaBusca(SQL);
			
		aux = false;
		try {
			while(rs.next()) {
				aux = true;
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		//if responsavel pela alteracao da senha 
		if(aux) {
				
			System.out.print("Digite sua nova senha: ");
			String novo = inputString.nextLine();
				
			//comando SQL responsavel pela atualizacao da senha
			SQL = "UPDATE aluno set senha='"+novo+"' where usuario='"+nome+"';";
			int res = AlteraSenha.executaSQL(SQL);
				
			if(res > 0) {
				System.out.println("Alteração de senha realizada com sucesso!");
			}else {
				System.out.println("Erro ao alterar a senha!");
			}
		}
		return true;
	}
	
	
	//metodo responsavel pela atualização dados do usuario
	public void update(Aluno aluno) {
			
		ConnectionFactory in = new ConnectionFactory();
		
		String UPDATE = "UPDATE ALUNO SET "
				+ "NOME="+aluno.getNome() 
				+" WHERE id_aluno="+aluno.getMatricula();
		
		in.executaSQL(UPDATE);
	
	}
	
	public Aluno visualizarAluno(int id) {
		ConnectionFactory consulta = new ConnectionFactory();
		String SQL = "select p.nome, a.frase_de_recuperacao from pessoa p, aluno a where matricula='"+id+"' and a.id_aluno = p.id_pessoa;";
		ResultSet rs = consulta.executaBusca(SQL);
		Aluno aluno = new Aluno();
		try {
			while(rs.next()) {
				aluno.setEmail(rs.getString("login"));
				aluno.setComplemento(rs.getString("complemento"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setNumero(rs.getString("numero"));
				aluno.setTelefone(rs.getString("telefone"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aluno;
	}
	
}