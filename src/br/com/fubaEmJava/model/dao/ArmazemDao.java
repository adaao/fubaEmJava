package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fubaEmJava.model.Armazem;

public class ArmazemDao {
	private Connection connection;
	private PreparedStatement stmt;
		
	public ArmazemDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionaArmazem(Armazem novoArmazem) {
		String sql = "INSERT INTO armazens "
						+ "(ds_armazem) "
				   + "VALUES "
				   		+ "(?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, novoArmazem.getDsArmazem());
			
			stmt.execute();
			stmt.close();
			if(novoArmazem.getDsArmazem().equals("teste")) {
				System.out.println("teste inserido na tabela");
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void alteraArmazem(Armazem tpDAmstra) {
		String sql = "UPDATE armazens SET "
				   + "ds_armazem = ? "
				   + "WHERE id_armazem = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tpDAmstra.getDsArmazem());
			stmt.setLong(2, tpDAmstra.getIdArmazem());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Armazem> listaArmazens() {
		try {
			List<Armazem> tipos = new ArrayList<Armazem>();
			String sql = "SELECT * FROM armazens";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				tipos.add(
						armazemFactoryFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return tipos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Armazem armazemFactoryFromResultSet(ResultSet rs) 
	throws SQLException{
		Armazem tpa = new Armazem();
		tpa.setIdArmazem(rs.getLong("id_armazem"));
		tpa.setDsArmazem(rs.getString("ds_armazem"));
		
		return tpa;
	}
}
