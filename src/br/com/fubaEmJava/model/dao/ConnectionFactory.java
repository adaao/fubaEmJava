package br.com.fubaEmJava.model.dao;

import java.sql.*;

public class ConnectionFactory {
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
