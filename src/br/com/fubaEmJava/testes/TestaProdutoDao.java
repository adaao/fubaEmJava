package br.com.fubaEmJava.testes;

import java.util.List;

import br.com.fubaEmJava.model.Produto;
import br.com.fubaEmJava.model.dao.ProdutoDao;

public class TestaProdutoDao {
	static ProdutoDao tpad = new ProdutoDao();
	static Produto ta = new Produto();

	public static void main(String[] args) {
		insereProduto();
		lista();
		alteraProduto();
		lista();

	}
	
	public static void insereProduto() {
		ta.setDsProduto("teste");
		tpad.adicionaProduto(ta);
	}
	
	public static void alteraProduto() {
		ta.setDsProduto("nova descricao do teste");
		ta.setIdProduto(1);
		tpad.alteraProduto(ta);
	}
	
	public static void lista() {
		List<Produto> tipos = tpad.listaProdutos();
		System.out.println("========== Tipos de produto cadastrados ==========");
		for(Produto t : tipos) {
			System.out.println("id: " + t.getIdProduto());
			System.out.println("descrição: " + t.getDsProduto());
			System.out.println("==================================================");
		}
	}
}

