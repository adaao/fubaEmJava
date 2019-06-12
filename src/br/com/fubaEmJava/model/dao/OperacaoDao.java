package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fubaEmJava.model.Operacao;

public class OperacaoDao {
	private Connection connection;
	private PreparedStatement stmt;
		
	public OperacaoDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionaOperacao(Operacao novoOperacao) {
		String sql = "INSERT INTO operacoes "
						+ "(ds_operacao) "
				   + "VALUES "
				   		+ "(?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, novoOperacao.getDsOperacao());
			
			stmt.execute();
			stmt.close();
			if(novoOperacao.getDsOperacao().equals("teste")) {
				System.out.println("teste inserido na tabela");
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void alteraOperacao(Operacao tpDAmstra) {
		String sql = "UPDATE operacoes SET "
				   + "ds_operacao = ? "
				   + "WHERE id_operacao = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tpDAmstra.getDsOperacao());
			stmt.setLong(2, tpDAmstra.getIdTipoDeOperacao());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Operacao> listaTiposDeAmostra() {
		try {
			List<Operacao> tipos = new ArrayList<Operacao>();
			String sql = "SELECT * FROM operacoes";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				tipos.add(
						operacaoFactoryFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return tipos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Operacao operacaoFactoryFromResultSet(ResultSet rs) 
	throws SQLException{
		Operacao tpa = new Operacao();
		tpa.setIdTipoDeOperacao(rs.getLong("id_operacao"));
		tpa.setDsOperacao(rs.getString("ds_operacao"));
		
		return tpa;
	}
}
