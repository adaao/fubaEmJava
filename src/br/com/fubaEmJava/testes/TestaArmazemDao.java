package br.com.fubaEmJava.testes;

import java.util.List;

import br.com.fubaEmJava.model.Armazem;
import br.com.fubaEmJava.model.dao.ArmazemDao;

public class TestaArmazemDao {
	static ArmazemDao tpad = new ArmazemDao();
	static Armazem ta = new Armazem();

	public static void main(String[] args) {
		insereArmazem();
		lista();
		alteraArmazem();
		lista();

	}
	
	public static void insereArmazem() {
		ta.setDsArmazem("teste");
		tpad.adicionaArmazem(ta);
	}
	
	public static void alteraArmazem() {
		ta.setDsArmazem("nova descricao do teste");
		ta.setIdArmazem(1);
		tpad.alteraArmazem(ta);
	}
	
	public static void lista() {
		List<Armazem> tipos = tpad.listaArmazens();
		System.out.println("========== Tipos de armazem cadastrados ==========");
		for(Armazem t : tipos) {
			System.out.println("id: " + t.getIdArmazem());
			System.out.println("descrição: " + t.getDsArmazem());
			System.out.println("==================================================");
		}
	}
}

