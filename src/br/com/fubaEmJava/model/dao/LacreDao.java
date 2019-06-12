package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fubaEmJava.model.Lacre;

public class LacreDao {
	private Connection connection;
	private PreparedStatement stmt;
		
	public LacreDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionaLacre(Lacre novoLacre) {
		String sql = "INSERT INTO lacres "
						+ "(ds_lacre, id_amostra) "
				   + "VALUES "
				   		+ "(?,?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, novoLacre.getDsLacre());
			stmt.setLong(2, novoLacre.getIdAmostra());
			
			stmt.execute();
			stmt.close();
			if(novoLacre.getDsLacre().equals("teste")) {
				System.out.println("teste inserido na tabela");
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void alteraLacre(Lacre lacre) {
		String sql = "UPDATE lacres SET "
				   + "ds_lacre = ? "
				   + "WHERE id_amostra = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, lacre.getDsLacre());
			stmt.setLong(2, lacre.getIdAmostra());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Lacre> listaTiposDeAmostra() {
		try {
			List<Lacre> tipos = new ArrayList<Lacre>();
			String sql = "SELECT * FROM lacres";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				tipos.add(
						lacreFactoryFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return tipos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Lacre lacreFactoryFromResultSet(ResultSet rs) 
	throws SQLException{
		Lacre tpa = new Lacre();
		tpa.setIdAmostra(rs.getLong("id_amostra"));
		tpa.setDsLacre(rs.getString("ds_lacre"));
		
		return tpa;
	}
}
