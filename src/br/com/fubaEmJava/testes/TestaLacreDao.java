package br.com.fubaEmJava.testes;

import java.util.List;

import br.com.fubaEmJava.model.Lacre;
import br.com.fubaEmJava.model.dao.LacreDao;

public class TestaLacreDao {
	static LacreDao tpad = new LacreDao();
	static Lacre ta = new Lacre();

	public static void main(String[] args) {
		insereLacre();
		lista();
		alteraLacre();
		lista();

	}
	
	public static void insereLacre() {
		ta.setDsLacre("teste");
		ta.setIdAmostra(1);
		tpad.adicionaLacre(ta);
	}
	
	public static void alteraLacre() {
		ta.setDsLacre("nova descricao do teste");
		ta.setIdAmostra(1);
		tpad.alteraLacre(ta);
	}
	
	public static void lista() {
		List<Lacre> lacres = tpad.listaTiposDeAmostra();
		System.out.println("========== Tipos de lacre cadastrados ==========");
		for(Lacre l : lacres) {
			System.out.println("id da amostra: " + l.getIdAmostra());
			System.out.println("descrição do lacre: " + l.getDsLacre());
			System.out.println("==================================================");
		}
	}
}

