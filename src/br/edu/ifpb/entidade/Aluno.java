package br.edu.ifpb.entidade;

import java.sql.ResultSet;
import java.util.Scanner;

import br.edu.ifpb.dao.DAOAluno;
import br.edu.ifpb.util.ConnectionFactory;

public class Aluno extends Pessoa{
	
	private String senha;
	private String usuario;
	private String fraseDeRecuperacao;
	private String RespostaDaFrase;
	
	Scanner input = new Scanner(System.in);
	
	/*metodo responsavel por verificar se o nome informado do usuario
	  ja existe no banco e se contem caracteres alem de letras 
	*/
	public void setUsuario(String usuario) {
		
		//loop responsavel por manter o usuario na tela de cadastro ate ele informar uma opcao valida
		while(true) {
			
			ConnectionFactory in = new ConnectionFactory();		
			String SQL = "select usuario from aluno where usuario='"+usuario+"';";
			
			ResultSet rs = in.executaBusca(SQL);
			

			//variavel temporaria responsavel por indicar se a consulta teve exito
			boolean aux = true;
			
			try {
				while(rs.next()) {
					System.out.print("Este usuario já existe!\nDigite um novo usuario: ");
					usuario = input.nextLine();
					rs.close();
					aux = false;
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
				break;
			}
			if(aux) {
				break;
			}
		}
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
	
	public String getFraseDeRecuperacao() {
		return fraseDeRecuperacao;
	}
	public void setFraseDeRecuperacao(String fraseDeRecuperacao) {
		this.fraseDeRecuperacao = fraseDeRecuperacao;
	}
	
	public String getRespostaDaFrase() {
		return RespostaDaFrase;
	}
	public void setRespostaDaFrase(String respostaDaFrase) {
		RespostaDaFrase = respostaDaFrase;
	}
	
	//metodo responsavel por inserir os dados informados pelo usuario no banco
	public void inserir() {
		DAOAluno banco = new DAOAluno();
		banco.inserirNoBanco(getNome(), getMatricula(), getEmail(), getTelefone(), getRua(), getNumero(), 
				getComplemento(), usuario, senha, fraseDeRecuperacao, RespostaDaFrase);
	}
}
