package br.edu.ifpb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionFactory {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/gerenciadordetarefas";
	private static final String USER = "postgres";
	private static final String PASS = "33293640";
	private Connection connection = null;
	private PreparedStatement stm = null;
	
	public ConnectionFactory() {
		iniciarConexao();
	}

	// Estabelecer conexão com o banco de dados
	public void iniciarConexao() {

		System.out.println("Estabelecendo conexão...");

		try {
			Class.forName(DRIVER);
			this.connection = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conectado!");
		} catch (Exception e) {
			System.out.println("Não foi possivel conectar ao banco de dados: "
					+ URL);
			e.printStackTrace();
		}
	}

	// Encerrar conexão com banco de dados
	public void encerrarConexao() {
		try {
			if (this.stm != null)
				this.stm.close();
			if (this.connection != null)
				this.connection.close();
			System.out.println("Conexão encerrada!!");
		} catch (Exception e) {
			System.out
					.println("Não foi possivel encerrar conexão ao banco de dados: "
							+ URL);
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

}