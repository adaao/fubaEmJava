package br.com.fubaEmJava.model;

public class Operacao {
	protected long idTipoDeOperacao;
	protected String dsOperacao;
	
	public long getIdTipoDeOperacao() {
		return idTipoDeOperacao;
	}
	public void setIdTipoDeOperacao(long idTipoDeOperacao) {
		this.idTipoDeOperacao = idTipoDeOperacao;
	}
	public String getDsOperacao() {
		return dsOperacao;
	}
	public void setDsOperacao(String dsOperacao) {
		this.dsOperacao = dsOperacao;
	}
	
}
