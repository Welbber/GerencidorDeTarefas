package br.edu.ifpb;

import java.util.Scanner;

public class Sistema {
	public void login(){
		Scanner inputInt = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		Aluno test = new Aluno("Welbber","123");
		System.out.println("\r\n" + 
				"				    __                _     \r\n" + 
				"				   / /   ____  ____ _(_)___ \r\n" + 
				"				  / /   / __ \\/ __ `/ / __ \\\r\n" + 
				"				 / /___/ /_/ / /_/ / / / / /\r\n" + 
				"				/_____/\\____/\\__, /_/_/ /_/ \r\n" + 
				"		    			        /____/          \r\n\n");
		while(true) {
			System.out.print("\nUsuario: ");
			String usuario = inputString.nextLine();
			System.out.print("\n\nSenha: ");
			String senha = inputString.nextLine();
			
			if(usuario.equalsIgnoreCase(test.getUsuario()) && senha.equals(test.getSenha())) {
				System.out.println("\nLogin com Sucesso!");
			}else {
				System.out.println("\n \n \n \nUsuario ou senha incorreto\n \nDigite 1 para tentar logar novamente\n"
						+ "Digite 2 para recuperar sua senha ou usuario");
				int aux = inputInt.nextInt();
				if(aux == 1) continue;
				else {
					
				}
			}
		}
	}
	public void CadastrarAluno(){
		Aluno test = new Aluno();
		Scanner inputString = new Scanner(System.in);
		Scanner inputLong = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		System.out.println("\r\n" + 
				" 	  ______               __                _                   \r\n" + 
				" 	.' ___  |             |  ]              / |_                 \r\n" + 
				"	/ .'   \\_| ,--.    .--.| |  ,--.   .--. `| |-'_ .--.   .--.   \r\n" + 
				"	| |       `'_\\ : / /'`\\' | `'_\\ : ( (`\\] | | [ `/'`\\]/ .'`\\ \\ \r\n" + 
				"	\\ `.___.'\\// | |,| \\__/  | // | |, `'.'. | |, | |    | \\__. | \r\n" + 
				"	 `.____ .'\\'-;__/ '.__.;__]\\'-;__/[\\__) )\\__/[___]    '.__.'  \r\n" + 
				"	                                                              \r\n");
		System.out.print("Nome: ");
		test.setNome(inputString.nextLine());
		
		System.out.print("\nUsuario: ");
		test.setUsuario(inputString.nextLine());
		
		System.out.print("\nSenha: ");
		test.setSenha(inputString.nextLine());
		
		System.out.print("\nMatricula: ");
		test.setMatricula(inputLong.nextLong());
		
		System.out.print("\nE-mail: ");
		test.setEmail(inputString.nextLine());
		
		System.out.print("\nTelefone: ");
		test.setTelefone(inputLong.nextLong());
		
		System.out.print("\nRua: ");
		test.setRua(inputString.nextLine());
		
		System.out.print("\nNumero: ");
		test.setNumero(inputInt.nextInt());
		
		System.out.print("\nComplemento: ");
		test.setComplemento(inputString.nextLine());
	}
}
