package br.com.fubaEmJava.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fubaEmJava.model.dao.ConnectionFactory;


public class TesteDeConexao {

	public static void main(String[] args) {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			System.out.println("Conexao aberta!");
			connection.close();
			System.out.println("***** Conexao fechada!!!! *****");
		}catch (SQLException e){
			System.out.println("Não foi possível se conectar...\n" + e);
		}
		
	}

}
