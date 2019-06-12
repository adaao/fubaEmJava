package br.com.fubaEmJava.model;

public class Produto {
	protected long idProduto;
	protected String dsProduto;
	
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long l) {
		this.idProduto = l;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	
}