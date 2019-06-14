package br.com.fubaEmJava.model;

import java.sql.Timestamp;

public class Amostra {
	protected long idAmostra;
	protected int dsQuantidade;
	protected long idTipoDeAmostra;
	protected long idProduto;
	protected long idArmazem;
	protected Timestamp dataDaColeta;
	protected String nomeDoInspetor;
	protected long idTipoDeOperacao;
	
	public long getIdAmostra() {
		return idAmostra;
	}
	public void setIdAmostra(long idAmostra) {
		this.idAmostra = idAmostra;
	}
	public int getDsQuantidade() {
		return dsQuantidade;
	}
	public void setDsQuantidade(int dsQuantidade) {
		this.dsQuantidade = dsQuantidade;
	}
	public long getIdTipoDeAmostra() {
		return idTipoDeAmostra;
	}
	public void setIdTipoDeAmostra(long l) {
		this.idTipoDeAmostra = l;
	}
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long l) {
		this.idProduto = l;
	}
	public long getIdArmazem() {
		return idArmazem;
	}
	public void setIdArmazem(long l) {
		this.idArmazem = l;
	}
	public Timestamp getDataDaColeta() {
		return dataDaColeta;
	}
	public void setDataDaColeta(Timestamp data) {
		this.dataDaColeta = data;
	}
	public String getNomeDoInspetor() {
		return nomeDoInspetor;
	}
	public void setNomeDoInspetor(String nomeDoInspetor) {
		this.nomeDoInspetor = nomeDoInspetor;
	}
	public long getIdTipoDeOperacao() {
		return idTipoDeOperacao;
	}
	public void setIdTipoDeOperacao(int idTipoDeOperacao) {
		this.idTipoDeOperacao = idTipoDeOperacao;
	}
	
}
