package br.edu.ifpb.entidade;

import java.util.Scanner;

public class Pessoa {
	private String nome;
	private String email;
	private long matricula;
	private long telefone;
	private String rua;
	private int numero;
	private String complemento;
	
	Scanner inputString = new Scanner(System.in);
	Scanner inputLong = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		while(true) {
			boolean aux = true;
			for(int i = 0; i < nome.length();i++) {
				char c[] = nome.toCharArray();
				if(!Character.isLetter(c[i]) && c[i] != ' ') {
					System.out.println("\n\nDigite um nome valido");
					aux = false;
					break;
				}
			}
			if(aux) break;
			else {
				System.out.print("\n\nNome: ");
				nome = inputString.nextLine();
			}
		}
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		while(true){
			String[] aux = email.split("");
			boolean veri = true;
			int cont = 2;
			for(int i = 0; i < aux.length;i++) {
				if(aux[i].equals("@")) {
					cont--;
				}
				if(aux[i].equals(".")) {
					cont--;
				}
			}
			if(!(cont == 0)) {
				System.out.println("\nE-mail invalido\n");
				System.out.print("Digite E-mail, novamente: ");
				email = inputString.nextLine();
			} else {
				this.email = email;
				break;
			}
		}
	}
	
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone){
		this.telefone = telefone;
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
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
