package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fubaEmJava.model.Produto;

public class ProdutoDao {
	private Connection connection;
	private PreparedStatement stmt;
		
	public ProdutoDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionaProduto(Produto novoProduto) {
		String sql = "INSERT INTO produtos "
						+ "(ds_produto) "
				   + "VALUES "
				   		+ "(?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, novoProduto.getDsProduto());
			
			stmt.execute();
			stmt.close();
			if(novoProduto.getDsProduto().equals("teste")) {
				System.out.println("teste inserido na tabela");
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void alteraProduto(Produto tpDAmstra) {
		String sql = "UPDATE produtos SET "
				   + "ds_produto = ? "
				   + "WHERE id_produto = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tpDAmstra.getDsProduto());
			stmt.setLong(2, tpDAmstra.getIdProduto());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Produto> listaProdutos() {
		try {
			List<Produto> tipos = new ArrayList<Produto>();
			String sql = "SELECT * FROM produtos";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				tipos.add(
						produtoFactoryFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return tipos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Produto produtoFactoryFromResultSet(ResultSet rs) 
	throws SQLException{
		Produto tpa = new Produto();
		tpa.setIdProduto(rs.getLong("id_produto"));
		tpa.setDsProduto(rs.getString("ds_produto"));
		
		return tpa;
	}
}
