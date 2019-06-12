package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fubaEmJava.model.TipoDeAmostra;

public class TipoDeAmostraDao {
	private Connection connection;
	private PreparedStatement stmt;
		
	public TipoDeAmostraDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionaTipoDeAmostra(TipoDeAmostra novoTipoDeAmostra) {
		String sql = "INSERT INTO tipodeamostra "
						+ "(ds_tipoDeAmostra) "
				   + "VALUES "
				   		+ "(?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, novoTipoDeAmostra.getDsTipoDeAmostra());
			
			stmt.execute();
			stmt.close();
			if(novoTipoDeAmostra.getDsTipoDeAmostra().equals("teste")) {
				System.out.println("teste inserido na tabela");
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void alteraTipoDeAmostra(TipoDeAmostra tpDAmstra) {
		String sql = "UPDATE tipodeamostra SET "
				   + "ds_tipoDeAmostra = ? "
				   + "WHERE id_tipoDeAmostra = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tpDAmstra.getDsTipoDeAmostra());
			stmt.setLong(2, tpDAmstra.getIdTipoDeAmostra());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<TipoDeAmostra> listaTiposDeAmostra() {
		try {
			List<TipoDeAmostra> tipos = new ArrayList<TipoDeAmostra>();
			String sql = "SELECT * FROM tipoDeAmostra";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				tipos.add(
						tipoDeAmostraFactoryFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return tipos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private TipoDeAmostra tipoDeAmostraFactoryFromResultSet(ResultSet rs) 
	throws SQLException{
		TipoDeAmostra tpa = new TipoDeAmostra();
		tpa.setIdTipoDeAmostra(rs.getLong("id_tipoDeAmostra"));
		tpa.setDsTipoDeAmostra(rs.getString("ds_tipoDeAmostra"));
		
		return tpa;
	}
	
}
