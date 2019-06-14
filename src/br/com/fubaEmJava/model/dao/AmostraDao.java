package br.com.fubaEmJava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fubaEmJava.model.Amostra;

public class AmostraDao {
	private Connection connection;
	private PreparedStatement stmt;
	
	public AmostraDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionaAmostraFull(Amostra amostra) {
		String sql = "INSERT INTO amostras "
				   + "(ds_quantidade, id_tipodeamostra, id_produto, id_armazem, date, ds_nomedoinspetor, id_tipodeoperacao, ds_lacre) "
				   + "VALUES "
				   + "(?,?,?,?,?,?,?,?) ";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, amostra.getDsQuantidade());
			stmt.setLong(2, amostra.getIdTipoDeAmostra());
			stmt.setLong(3, amostra.getIdProduto());
			stmt.setLong(4, amostra.getIdArmazem());
			//stmt.setString(5, amostra.getDataDaColeta());
			Calendar data = Calendar.getInstance();
		    stmt.setTimestamp(5, amostra.getDataDaColeta());
			stmt.setString(6, amostra.getNomeDoInspetor());
			stmt.setLong(7, amostra.getIdTipoDeOperacao());
			stmt.setString(8, amostra.getLacre());
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void adicionaAmostra(Amostra amostra) {
		String sql = "INSERT INTO amostras "
				   + "(ds_quantidade, id_tipodeamostra, id_produto, id_armazem, ds_nomedoinspetor, id_tipodeoperacao, ds_lacre) "
				   + "VALUES "
				   + "(?,?,?,?,?,?,?) ";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, amostra.getDsQuantidade());
			stmt.setLong(2, amostra.getIdTipoDeAmostra());
			stmt.setLong(3, amostra.getIdProduto());
			stmt.setLong(4, amostra.getIdArmazem());
			stmt.setString(5, amostra.getNomeDoInspetor());
			stmt.setLong(6, amostra.getIdTipoDeOperacao());
			stmt.setString(7, amostra.getLacre());
			
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void alteraAmostra(Amostra amostra) {
		String sql = "UPDATE amostras SET "
				   + "ds_quantidade = ?, "
				   + "id_tipodeamostra = ?, "
				   + "id_produto = ?, "
				   + "id_armazem = ?, "
				   //+ "dt_datadacoleta = ?, "
				   + "ds_nomedoinspetor = ?, "
				   + "id_tipodeoperacao = ?, "
				   + "ds_lacre = ? "
				   + "WHERE id_amostra = ? ";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, amostra.getDsQuantidade());
			stmt.setLong(2, amostra.getIdTipoDeAmostra());
			stmt.setLong(3, amostra.getIdProduto());
			stmt.setLong(4, amostra.getIdArmazem());
			//stmt.setDate(5, amostra.getDataDaColeta());
			stmt.setString(5, amostra.getNomeDoInspetor());
			stmt.setLong(6, amostra.getIdTipoDeOperacao());
			stmt.setString(7, amostra.getLacre());
			stmt.setLong(8, amostra.getIdAmostra());
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Amostra> listaAmostras() {
		try {
			List<Amostra> amostras = new ArrayList<Amostra>();
			String sql = "SELECT * FROM amostras";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				amostras.add(
					amostrasFactoryFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return amostras;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Amostra amostrasFactoryFromResultSet(ResultSet rs) 
	throws SQLException {
		Amostra a = new Amostra();
		a.setIdAmostra(rs.getLong("id_amostra"));
		a.setDsQuantidade(rs.getInt("ds_quantidade"));
		a.setIdTipoDeAmostra(rs.getLong("id_tipodeamostra"));
		a.setIdProduto(rs.getLong("id_produto"));
		a.setIdArmazem(rs.getLong("id_armazem"));
		//Timestamp data = Calendar.getInstance();
		a.setDataDaColeta(rs.getTimestamp("dt_datadacoleta"));
		a.setNomeDoInspetor(rs.getString("ds_nomedoinspetor"));
		a.setLacre(rs.getString("ds_lacre"));
		
		return a;
	}
}
