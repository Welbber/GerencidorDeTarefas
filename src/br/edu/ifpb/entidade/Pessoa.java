package br.edu.ifpb.entidade;

import java.sql.ResultSet;
import java.util.Scanner;

import br.edu.ifpb.util.ConnectionFactory;

public class Pessoa {
	
	private String nome;
	private String email;
	private int matricula;
	private String telefone;
	private String rua;
	private int numero;
	private String complemento;
	
	Scanner input = new Scanner(System.in);
	
	public String getNome() {
		return nome;
	}
	
	/*metodo responsavel por verificar a entrada do usuario, retornado
	  uma mensagem de erro ao usuario informar um nome invalido
	*/
	public void setNome(String nome) {
		
		//loop responsavel por manter o usaurio ate ele digitar uma opcao valida
		while(true) {
			boolean aux = true;
			for(int i = 0; i < nome.length();i++) {
				char c[] = nome.toCharArray();
				if(!Character.isLetter(c[i]) && c[i] != ' ') {
					System.out.println("Digite um nome valido");
					aux = false;
					break;
				}
			}
			//if responsavel por analisar se houve ou nao uma entrada indevida no nome
			if(aux) break;
			else {
				System.out.print("Nome: ");
				nome = input.nextLine();
			}
		}
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	/*metodo responsavel por verificar se o usuario digitou
	 um email valido contendo um arroba e um ponto
	 */
	public void setEmail(String email) {
		
		//loop responsavel por manter o usuario ate ele digitar uma opcao valida
		while(true){
			String[] aux = email.split("");
			int cont = 2;
			for(int i = 0; i < aux.length;i++) {
				if(aux[i].equals("@")) {
					cont--;
				}
				if(aux[i].equals(".")) {
					cont--;
				}
			}
			//if responsavel por analisar a verificacao
			if(!(cont == 0)) {
				System.out.println("\nE-mail invalido");
				System.out.print("Digite E-mail novamente: ");
				email = input.nextLine();
			} else {
				this.email = email;
				break;
			}
		}
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	// metodo responsavel por verificar a entrada do usuario
	public void setMatricula(String matricula) {
		
		//lopp responsavel por manter o usuario ate ele digitar uma opcao valida
		while(true) {
			if(matricula.matches("[0-9]+")){
				this.matricula = Integer.parseInt(matricula);
				break;
			}else {
				System.out.println("\nMatricula invalida");
				System.out.print("Digite a matricula novamente: ");
				matricula = input.nextLine();
			}
		}
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone){
		this.telefone =telefone;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getNumero() {
		return numero;
	}
	
	//metodo responsavel por verificar a entrada do usuario
	public void setNumero(String numero) {
		
		//loop responsavel por manter o usuario ate ele digitar uma opcao valida
		while(true) {
			//if que contem uma expressao regular onde verifica se o atributo so contem numeros
			if(numero.matches("[0-9]+")){
				this.numero = Integer.parseInt(numero);
				break;
			}else {
				System.out.println("\nNumero invalido");
				System.out.print("Digite um numero novamente: ");
				numero = input.nextLine();
			}
		}
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
