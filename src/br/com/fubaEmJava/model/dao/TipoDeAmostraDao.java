package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fubaEmJava.model.TipoDeAmostra;

public class TipoDeAmostraDao {
	private Connection connection;
	private PreparedStatement stmt;
	private String mnsg;
	
	public TipoDeAmostraDao() {
		this.connection = ConnectionFactory.getConnection();
		mnsg = "Nao implementado\n";
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
	
	public TipoDeAmostra buscaTipoDeAmostra(int idTipoDeAmostra) {
		TipoDeAmostra tpa = new TipoDeAmostra();
		System.out.println(mnsg);
		return tpa;
	}
	
	private TipoDeAmostra tipoDeAmostraFactoryFromResultSet(ResultSet rs) 
	throws SQLException{
		TipoDeAmostra tpa = new TipoDeAmostra();
		tpa.setIdTipoDeAmostra(rs.getLong("id_tipoDeAmostra"));
		tpa.setDsTipoDeAmostra(rs.getString("ds_tipoDeAmostra"));
		
		return tpa;
	}
	
}
