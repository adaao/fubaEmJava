package br.com.fubaEmJava.testes;

import br.com.fubaEmJava.model.TipoDeAmostra;
import br.com.fubaEmJava.model.dao.TipoDeAmostraDao;

public class TestaTipoDeAmostraDao {
	static TipoDeAmostraDao tpad = new TipoDeAmostraDao();
	static TipoDeAmostra ta = new TipoDeAmostra();
	
	public static void main(String[] args) {
		//insereTipoDeAmostra();
		alteraTipoDeAmostra();
		
		
	}
	
	public static void insereTipoDeAmostra() {
		ta.setDsTipoDeAmostra("teste");
		tpad.adicionaTipoDeAmostra(ta);
	}
	
	public static void alteraTipoDeAmostra() {
		ta.setDsTipoDeAmostra("nova descricao do teste");
		ta.setIdTipoDeAmostra(1);
		tpad.alteraTipoDeAmostra(ta);
	}
}
