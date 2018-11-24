package br.edu.ifpb.main;

import java.sql.ResultSet;
import java.util.Scanner;

import br.edu.ifpb.entidade.Aluno;
import br.edu.ifpb.entidade.Pessoa;
import br.edu.ifpb.util.ConnectionFactory;

public class Principal {
	public static void main(String[] args) {
		inicio();
	}
	
	//metodo responsavel pela primeira tela que aparece para o usuario
	public static void inicio() {
		
		//objeto responsavel por conter as funcionalidades do sistema
		Sistema system = new Sistema();
		
		//objeto responsavel pelos dados do aluno
		Aluno aluno = new Aluno();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\r\n" + 
				"	 ______                                  _                 __         \r\n" + 
				"	|_   _ \\                                (_)               |  ]        \r\n" + 
				"	  | |_) |  .---.  _ .--..--.    _   __  __   _ .--.   .--.| |  .--.   \r\n" + 
				"	  |  __'. / /__\\\\[ `.-. .-. |  [ \\ [  ][  | [ `.-. |/ /'`\\' |/ .'`\\ \\ \r\n" + 
				"	 _| |__) || \\__., | | | | | |   \\ \\/ /  | |  | | | || \\__/  || \\__. | \r\n" + 
				"	|_______/  '.__.'[___||__||__]   \\__/  [___][___||__]'.__.;__]'.__.'  \r\n" + 
				"                                                                      \r\n");
		
		//loop da tela incial
		while(true) {	
			System.out.println("Digite 1 para fazer login\n"
					+ "Digite 2 para cadastrar-se\n"
					+ "Digite 3 para sair");
			System.out.print("Digite: ");
			String opcao = input.nextLine();
			//if responsavel pela entrada do usuario
			if(opcao.equals("1")) {
				system.login();
				break;
			}
			else if(opcao.equals("2")) {
				system.CadastrarAluno();
				continue;
			}else if(opcao.equals("3")){
				System.exit(0);
			}else {
				System.out.println("Op��o invalida!\n");
			}
		}
		input.close();
	}
	public static void menuAluno() {
		Sistema system = new Sistema();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("01 - Editar perfil\t\t"
					+ "06 - Cadastrar professor\n"
					+ "02 - Editar professor\t\t"
					+ "07 - Vizualizar professor\n"
					+ "03 - Cadastrar disciplina\t"
					+ "08 - Editar disciplina\n"
					+ "04 - Vizualizar disciplina\t"
					+ "09 - Cadastrar tarefa\n"
					+ "05 - Editar tarefa\t\t"
					+ "10 - Vizualizar tarefa\n");
			System.out.print("Digite: ");
			int opcao = input.nextInt();
			
			if(opcao == 1) {
				system.editarPerfil();
				break;
			}
			else if(opcao == 2) {
				system.editarProfessor();
				break;
			}
			else if (opcao == 3) {
				system.CadastrarDisciplina();
				break;
			} 
			else if (opcao == 4) {
				system.vizualizarDisciplina();
				break;
			}
			else if (opcao == 5) {
				system.editarTarefa();
				break;
			}
			else if (opcao == 6) {
				system.cadastrarProfessor();
				break;
			}
			else if (opcao == 7) {
				system.vizualizarProfessor();
				break;
			}
			else if (opcao == 8) {
				system.editarDisciplina();
				break;
			}
			else if (opcao == 9) {
				system.cadastrarTarefa();
				break;
			}
			else if (opcao == 10) {
				system.vizualizarTarefa();
				break;
			}
			else {
				System.out.println("Digite um numero valido");
			}
		}
		input.close();
	}
}