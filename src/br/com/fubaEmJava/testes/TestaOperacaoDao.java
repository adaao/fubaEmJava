package br.com.fubaEmJava.testes;

import java.util.List;

import br.com.fubaEmJava.model.Operacao;
import br.com.fubaEmJava.model.dao.OperacaoDao;

public class TestaOperacaoDao {
	static OperacaoDao tpad = new OperacaoDao();
	static Operacao ta = new Operacao();

	public static void main(String[] args) {
		insereOperacao();
		lista();
		alteraOperacao();
		lista();

	}
	
	public static void insereOperacao() {
		ta.setDsOperacao("teste");
		tpad.adicionaOperacao(ta);
	}
	
	public static void alteraOperacao() {
		ta.setDsOperacao("nova descricao do teste");
		ta.setIdTipoDeOperacao(1);
		tpad.alteraOperacao(ta);
	}
	
	public static void lista() {
		List<Operacao> tipos = tpad.listaTiposDeAmostra();
		System.out.println("========== Tipos de operacao cadastrados ==========");
		for(Operacao t : tipos) {
			System.out.println("id: " + t.getIdTipoDeOperacao());
			System.out.println("descrição: " + t.getDsOperacao());
			System.out.println("==================================================");
		}
	}
}

