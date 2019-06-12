package br.com.fubaEmJava.testes;

import java.util.List;

import br.com.fubaEmJava.model.TipoDeAmostra;
import br.com.fubaEmJava.model.dao.TipoDeAmostraDao;

public class TestaTipoDeAmostraDao {
	static TipoDeAmostraDao tpad = new TipoDeAmostraDao();
	static TipoDeAmostra ta = new TipoDeAmostra();
	
	public static void main(String[] args) {
		//insereTipoDeAmostra();
		//alteraTipoDeAmostra();
		lista();
		
		
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
	
	public static void lista() {
		List<TipoDeAmostra> tipos = tpad.listaTiposDeAmostra();
		System.out.println("========== Tipos de amostra cadastrados ==========");
		for(TipoDeAmostra t : tipos) {
			System.out.println("id: " + t.getIdTipoDeAmostra());
			System.out.println("descrição: " + t.getDsTipoDeAmostra());
			System.out.println("==================================================");
		}
	}
}
