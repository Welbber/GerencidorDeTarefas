package br.edu.ifpb.main;

import java.sql.ResultSet;
import java.util.Scanner;

import br.edu.ifpb.dao.DAOAluno;
import br.edu.ifpb.entidade.Aluno;
import br.edu.ifpb.util.ConnectionFactory;

public class Sistema {
	DAOAluno banco = new DAOAluno();
	Scanner inputInt = new Scanner(System.in);
	Scanner inputString = new Scanner(System.in);
	
	//metodo responsavel pela verificacao no banco com a entrada do usuario
	public void login(){
		
		System.out.println("\r\n" + 
				"				    __                _     \r\n" + 
				"				   / /   ____  ____ _(_)___ \r\n" + 
				"				  / /   / __ \\/ __ `/ / __ \\\r\n" + 
				"				 / /___/ /_/ / /_/ / / / / /\r\n" + 
				"				/_____/\\____/\\__, /_/_/ /_/ \r\n" + 
				"		    			        /____/          \r\n\n");
		
		//loop responsavel pela tela de login
		while(true) {
			System.out.print("Usuario: ");
			String usuario = inputString.nextLine();
			
			System.out.print("Senha: ");
			String senha = inputString.nextLine();
			
			//objeto responsavel pela comunicacao com o banco
			ConnectionFactory con = new ConnectionFactory();
			
			//comando sql que compara a entrada do usuario com os atributos do banco
			String sql = "SELECT usuario,senha FROM aluno WHERE usuario='"+usuario+"' AND senha='"+senha+"'";
			
			//variavel temporaria responsavel pela afirmacao do comando sql
			boolean aux = false;
			
			ResultSet rs = con.executaBusca(sql);
			
			try {
				while(rs.next()){
					aux = true;
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//if responsavel pela opcoes mostadas ao usuario apos o login
			if(aux) {
				System.out.println("Login realizado com sucesso!!");
			}else {
				System.out.println("\nUsuario ou senha incorreto\n \nDigite 1 para tentar logar novamente ou\n"
						+ "2 para recuperar sua senha ou usuario");
				
				String op = inputString.nextLine();
				
				/*if responsavel pelas opcoes que seram mostradas ao usuario apos
				  ele ter digitado uma senha ou nome de usuario invalido
				 */
				if(op.equals("1")) {
					break;
				}else if(op.equals("2")) {
					System.out.print("\nDigite seu nome: ");
					String nome = inputString.nextLine();
					
					//objeto responsavel por recuperar a senha do usuario se o nome existir
					banco.recuperaSenha(nome);
				}else {
					System.out.println("Opção invalida!");
				}
			}
		}
	}
	
	
	
	//metodo responsavel por receber os dados do usuario e chamar a classe DAOAluno para inserir no banco
	public void CadastrarAluno(){
		Aluno aluno = new Aluno();
		Scanner input = new Scanner(System.in);
		
		System.out.println("\r\n" + 
				" 	  ______               __                _                   \r\n" + 
				" 	.' ___  |             |  ]              / |_                 \r\n" + 
				"	/ .'   \\_| ,--.    .--.| |  ,--.   .--. `| |-'_ .--.   .--.   \r\n" + 
				"	| |       `'_\\ : / /'`\\' | `'_\\ : ( (`\\] | | [ `/'`\\]/ .'`\\ \\ \r\n" + 
				"	\\ `.___.'\\// | |,| \\__/  | // | |, `'.'. | |, | |    | \\__. | \r\n" + 
				"	 `.____ .'\\'-;__/ '.__.;__]\\'-;__/[\\__) )\\__/[___]    '.__.'  \r\n" + 
				"	                                                              \r\n");
		System.out.print("Nome: ");
		aluno.setNome(input.nextLine());
		
		System.out.print("\nUsuario: ");
		
		aluno.setUsuario(input.nextLine());
		
		System.out.print("\nSenha: ");
		aluno.setSenha(input.nextLine());
		
		System.out.print("\nMatricula: ");
		aluno.setMatricula(input.nextLine());
		
		System.out.print("\nE-mail: ");
		aluno.setEmail(input.nextLine());
		
		System.out.print("\nTelefone: ");
		aluno.setTelefone(input.nextLine());
		
		System.out.print("\nRua: ");
		aluno.setRua(input.nextLine());
		
		System.out.print("\nNumero: ");
		aluno.setNumero(input.nextLine());
		
		System.out.print("\nComplemento: ");
		aluno.setComplemento(input.nextLine());
		System.out.println("\n");
	
		System.out.print("\nDigite um frase para recuperar sua conta, caso necessario\nExemplo de frase "+
				"\"Qual nome do seu amigo de infancia?\" ");
		aluno.setFraseDeRecuperacao(input.nextLine());
		
		System.out.print("\nDigite a resposta da frase: ");
		aluno.setRespostaDaFrase(input.nextLine());
		
		aluno.inserir();
	}
	public void editarPerfil() {
		// TODO Auto-generated method stub
		
	}
	public void editarProfessor() {
		// TODO Auto-generated method stub
		
	}
	public void CadastrarDisciplina() {
		// TODO Auto-generated method stub
		
	}
	public void vizualizarDisciplina() {
		// TODO Auto-generated method stub
		
	}
	public void editarTarefa() {
		// TODO Auto-generated method stub
		
	}
	public void cadastrarProfessor() {
		// TODO Auto-generated method stub
		
	}
	public void vizualizarProfessor() {
		// TODO Auto-generated method stub
		
	}
	public void editarDisciplina() {
		// TODO Auto-generated method stub
		
	}
	public void cadastrarTarefa() {
		// TODO Auto-generated method stub
		
	}
	public void vizualizarTarefa() {
		// TODO Auto-generated method stub
		
	}
}
