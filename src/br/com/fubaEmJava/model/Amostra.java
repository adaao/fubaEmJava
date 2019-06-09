package br.com.fubaEmJava.model;

public class Amostra {
	protected long idAmostra;
	protected int dsQuantidade;
	protected long idTipoDeAmostra;
	protected long idProduto;
	protected long idArmazem;
	protected String dataDaColeta;
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
	public void setIdTipoDeAmostra(int idTipoDeAmostra) {
		this.idTipoDeAmostra = idTipoDeAmostra;
	}
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public long getIdArmazem() {
		return idArmazem;
	}
	public void setIdArmazem(int idArmazem) {
		this.idArmazem = idArmazem;
	}
	public String getDataDaColeta() {
		return dataDaColeta;
	}
	public void setDataDaColeta(String dataDaColeta) {
		this.dataDaColeta = dataDaColeta;
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
