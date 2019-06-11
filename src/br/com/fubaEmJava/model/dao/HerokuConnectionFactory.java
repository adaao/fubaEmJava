package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HerokuConnectionFactory {
	public Connection getConnection() {
		try {
			String urlDoBd = "jdbc:postgresql:fuba";
			String user = "eclipse";
			String password = "407186";
			return DriverManager.getConnection(urlDoBd,user, password);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
