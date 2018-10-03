package br.edu.ifpb;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Sistema system = new Sistema();
		Scanner input = new Scanner(System.in);
		System.out.println("\r\n" + 
				"	 ______                                  _                 __         \r\n" + 
				"	|_   _ \\                                (_)               |  ]        \r\n" + 
				"	  | |_) |  .---.  _ .--..--.    _   __  __   _ .--.   .--.| |  .--.   \r\n" + 
				"	  |  __'. / /__\\\\[ `.-. .-. |  [ \\ [  ][  | [ `.-. |/ /'`\\' |/ .'`\\ \\ \r\n" + 
				"	 _| |__) || \\__., | | | | | |   \\ \\/ /  | |  | | | || \\__/  || \\__. | \r\n" + 
				"	|_______/  '.__.'[___||__||__]   \\__/  [___][___||__]'.__.;__]'.__.'  \r\n" + 
				"                                                                      \r\n");
		while(true) {	
			System.out.println("Digite 1 para fazer login\n"
					+ "Digite 2 para cadastrasse\n"
					+ "Digite 3 para sair");
			System.out.print("Digite: ");
			int opcao = input.nextInt();
			
			if(opcao == 1) {
				system.login();
			}
			if(opcao == 2) {
				system.CadastrarAluno();
			}
		}
	}
}